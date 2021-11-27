package top.lbqaq.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.lbqaq.dto.TrainDTO;import top.lbqaq.model.Train;

@Mapper
public interface TrainMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Train record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Train record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Train selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Train record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Train record);

    List<Train> selectByAll(Train train);

    List<Train> selectAll();

    List<TrainDTO> selectAllDto();

    TrainDTO selectDtoById(String id);
}