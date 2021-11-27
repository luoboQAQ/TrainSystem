package top.lbqaq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lbqaq.dto.TrainDTO;
import top.lbqaq.model.City;
import top.lbqaq.model.Train;
import top.lbqaq.service.CityService;
import top.lbqaq.service.TrainService;

import java.util.List;

/**
 * @author luoboQAQ
 * @Date 2021/11/11
 */
@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;
    @Autowired
    private CityService cityService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<TrainDTO> trainList = trainService.selectAllDto();
        model.addAttribute("trainList", trainList);
        return "train/list";
    }

    @RequestMapping("/admin/train")
    public String toTrain(Model model) {
        List<TrainDTO> trainList = trainService.selectAllDto();
        model.addAttribute("trainList", trainList);
        return "train/admin";
    }

    @RequestMapping("/admin/train/remove")
    public String delTrain(@RequestParam("id") String id, Model model) {
        Train train = trainService.selectByPrimaryKey(id);
        if (train == null) {
            model.addAttribute("msg", "错误！无法找到该车次");
            return "end";
        }
        if (trainService.deleteByPrimaryKey(id) == 0) {
            model.addAttribute("msg", "错误！无法删除该车次");
            return "end";
        }
        model.addAttribute("msg", "删除成功");
        return "end";
    }

    @GetMapping("/admin/train/edit")
    public String toEdit(String id, Model model) {
        List<City> cities = cityService.selectAll();
        Train train = new Train();
        if (id != null) {
            train = trainService.selectByPrimaryKey(id);
        }
        model.addAttribute("train", train);
        model.addAttribute("cities", cities);
        return "train/edit";
    }

    @PostMapping("/admin/train/edit")
    public String editTrain(Train train, Model model) {
        if (train == null) {
            model.addAttribute("msg", "错误！未输入数据");
            return "end";
        }
        Train dbTrain = trainService.selectByPrimaryKey(train.getId());
        if (dbTrain == null) {
            if (trainService.insertSelective(train) == 0) {
                model.addAttribute("msg", "错误！插入数据失败");
                return "end";
            }
            model.addAttribute("msg", "插入成功");
            return "end";
        } else {
            if (trainService.updateByPrimaryKeySelective(train) == 0) {
                model.addAttribute("msg", "错误！插入失败");
                return "end";
            }
            model.addAttribute("msg", "更新成功");
            return "end";
        }
    }
}
