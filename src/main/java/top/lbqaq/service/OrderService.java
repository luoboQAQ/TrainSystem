package top.lbqaq.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.lbqaq.dto.OrderListDTO;
import top.lbqaq.dto.SumDTO;
import top.lbqaq.mapper.OrderMapper;
import java.util.List;
import top.lbqaq.model.Order;
@Service
public class OrderService{

    @Resource
    private OrderMapper orderMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    
    public List<Order> selectAllByUserId(Long userId) {
        return orderMapper.selectAllByUserId(userId);
    }

    public List<OrderListDTO> selectAllByUserIdDTO(Long userId){return orderMapper.selectAllByUserIdDTO(userId);}

    public List<SumDTO> selectSumList(){return orderMapper.selectSumList();}
}
