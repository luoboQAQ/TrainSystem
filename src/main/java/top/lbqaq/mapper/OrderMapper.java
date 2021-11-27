package top.lbqaq.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.lbqaq.dto.OrderDTO;
import top.lbqaq.dto.OrderListDTO;
import top.lbqaq.dto.SumDTO;
import top.lbqaq.model.Order;

@Mapper
public interface OrderMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Order record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Order record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Order selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Order record);

    List<Order> selectAllByUserId(@Param("userId") Long userId);

    List<OrderListDTO> selectAllByUserIdDTO(Long userId);

    List<SumDTO> selectSumList();
}