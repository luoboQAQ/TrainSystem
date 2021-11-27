package top.lbqaq.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.lbqaq.mapper.CityMapper;
import top.lbqaq.model.City;

import java.util.List;

@Service
public class CityService{

    @Resource
    private CityMapper cityMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(City record) {
        return cityMapper.insert(record);
    }

    
    public int insertSelective(City record) {
        return cityMapper.insertSelective(record);
    }

    
    public City selectByPrimaryKey(Long id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(City record) {
        return cityMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(City record) {
        return cityMapper.updateByPrimaryKey(record);
    }

    public List<City> selectAll(){return cityMapper.selectAll();}
}
