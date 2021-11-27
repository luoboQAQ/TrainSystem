package top.lbqaq.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import top.lbqaq.dto.TrainDTO;
import top.lbqaq.model.Train;
import top.lbqaq.mapper.TrainMapper;

@Service
public class TrainService {

    @Resource
    private TrainMapper trainMapper;


    public int deleteByPrimaryKey(String id) {
        return trainMapper.deleteByPrimaryKey(id);
    }


    public int insert(Train record) {
        return trainMapper.insert(record);
    }


    public int insertSelective(Train record) {
        return trainMapper.insertSelective(record);
    }


    public Train selectByPrimaryKey(String id) {
        return trainMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Train record) {
        return trainMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Train record) {
        return trainMapper.updateByPrimaryKey(record);
    }


    public List<Train> selectAll() {
        return trainMapper.selectAll();
    }

    public List<TrainDTO> selectAllDto() {
        return trainMapper.selectAllDto();
    }

    public TrainDTO selectDtoById(String id) {
        return trainMapper.selectDtoById(id);
    }

    public List<Train> selectByAll(Train train) {
        return trainMapper.selectByAll(train);
    }
}

