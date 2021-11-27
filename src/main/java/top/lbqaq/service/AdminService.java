package top.lbqaq.service;

import org.springframework.stereotype.Service;
import top.lbqaq.mapper.AdminMapper;
import top.lbqaq.model.Admin;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;


    public int deleteByPrimaryKey(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }


    public int insert(Admin record) {
        return adminMapper.insert(record);
    }


    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }


    public Admin selectByPrimaryKey(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }
}
