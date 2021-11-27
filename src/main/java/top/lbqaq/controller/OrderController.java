package top.lbqaq.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lbqaq.dto.OrderDTO;
import top.lbqaq.dto.OrderListDTO;
import top.lbqaq.dto.SumDTO;
import top.lbqaq.dto.TrainDTO;
import top.lbqaq.model.Order;
import top.lbqaq.model.Train;
import top.lbqaq.model.User;
import top.lbqaq.service.OrderService;
import top.lbqaq.service.TrainService;
import top.lbqaq.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author luoboQAQ
 * @Date 2021/11/11
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    TrainService trainService;
    @Autowired
    UserService userService;

    @RequestMapping("/order")
    public String order(HttpSession session, Model model) {
        List<OrderListDTO> orderList = orderService.selectAllByUserIdDTO((Long) session.getAttribute("userId"));
        model.addAttribute("orderList", orderList);
        return "order/order";
    }

    @GetMapping("/buy")
    public String toBuy(@RequestParam("id") String trainId, HttpSession session, Model model) {
        TrainDTO trainDTO = trainService.selectDtoById(trainId);
        User user = userService.selectByPrimaryKey((Long) session.getAttribute("userId"));
        List<Order> orders = orderService.selectAllByUserId(user.getId());
        if (orders.isEmpty()) {
            model.addAttribute("hasOrder", false);
        } else {
            model.addAttribute("hasOrder", true);
        }
        model.addAttribute("user", user);
        model.addAttribute("trainDTO", trainDTO);
        return "order/buy";
    }

    @PostMapping("/buy")
    public String addOrder(OrderDTO orderDTO, Model model) {
        TrainDTO trainDTO = trainService.selectDtoById(orderDTO.getTrainId());
        int orderNumber = orderDTO.getNumber();
        if (orderNumber > trainDTO.getNumber()) {
            model.addAttribute("msg", "错误：订票数量超过剩余票数！");
            return "end";
        }
        Order order = new Order();
        order.setNumber(orderNumber);
        order.setTime(new Date());
        order.setUserId(orderDTO.getUserId());
        order.setTrainId(orderDTO.getTrainId());
        if (orderService.insertSelective(order) == 0) {
            model.addAttribute("msg", "错误：插入订单失败！");
            return "end";
        }
        if (!orderDTO.getHasOrder()) {
            User user = new User();
            user.setId(orderDTO.getUserId());
            user.setRealName(orderDTO.getRealName());
            user.setSex(orderDTO.getSex());
            user.setIdCard(orderDTO.getIdCard());
            if (userService.updateByPrimaryKeySelective(user) == 0) {
                model.addAttribute("msg", "错误：插入个人信息失败！");
                return "end";
            }
        }
        Train train = new Train();
        train.setId(trainDTO.getId());
        train.setNumber(trainDTO.getNumber() - orderNumber);
        if (trainService.updateByPrimaryKeySelective(train) == 0) {
            model.addAttribute("msg", "错误：更新列车信息失败！");
            return "end";
        }
        model.addAttribute("time",new Date());
        model.addAttribute("order", order);
        model.addAttribute("price", trainDTO.getPrice() * order.getNumber());
        if (!orderDTO.getHasOrder()) {
            model.addAttribute("name", orderDTO.getRealName());
        }
        return "order/price";
    }

    @RequestMapping("/rebuy")
    public String reBuy(@RequestParam("id") Long id, Model model) {
        Order order = orderService.selectByPrimaryKey(id);
        if (order == null) {
            model.addAttribute("msg", "错误！不存在此订单");
            return "end";
        }
        if (orderService.deleteByPrimaryKey(id) == 0) {
            model.addAttribute("msg", "错误！删除订单失败");
            return "end";
        }
        Train train = trainService.selectByPrimaryKey(order.getTrainId());
        train.setNumber(train.getNumber() + order.getNumber());
        if (trainService.updateByPrimaryKeySelective(train) == 0) {
            model.addAttribute("msg", "错误！更新列车信息失败");
            return "end";
        }
        model.addAttribute("msg", "您已成功退票");
        return "end";
    }

    @RequestMapping("/ticket")
    public String showTicket(@RequestParam("id") Long id,Model model){
        Order order = orderService.selectByPrimaryKey(id);
        if(order==null){
            model.addAttribute("msg", "错误！不存在此车票");
            return "end";
        }
        User user = userService.selectByPrimaryKey(order.getUserId());
        TrainDTO trainDTO = trainService.selectDtoById(order.getTrainId());
        model.addAttribute("order", order);
        model.addAttribute("user",user);
        model.addAttribute("trainDTO",trainDTO);
        return "order/ticket";
    }

    @RequestMapping("/admin/sum")
    public String toSum(Model model){
        List<SumDTO> sumList = orderService.selectSumList();
        model.addAttribute("sumList",sumList);
        return "order/admin";
    }
}
