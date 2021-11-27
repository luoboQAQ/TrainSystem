package top.lbqaq.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.lbqaq.model.City;

@Mapper
public interface CityMapper {
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
    int insert(City record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(City record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    City selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(City record);

    List<City> selectAll();


}