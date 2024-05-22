package com.service412.rdn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.config.JwtConfig;
import com.service412.rdn.mapper.JobMapper;
import com.service412.rdn.mapper.UserMapper;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Job;
import com.service412.rdn.model.entity.User;
import com.service412.rdn.model.vo.JobInfoVo;
import com.service412.rdn.service.JobService;
import com.service412.rdn.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private UserMapper userMapper;
    // 根据名称搜索职位
    public PageListResponse getJobList(long current, long pageSize, String jobName, String token){
        String UserId = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        User user = userMapper.selectById(UserId);
        Page<JobInfoVo> page = null;
        // 分页查询
        if(user.getRole().getValue() != 2) {
            page = jobMapper.getJobList(new Page<>(current, pageSize), jobName);
        }else{
            page = jobMapper.getJobAllList(new Page<>(current, pageSize), jobName);
        }

        PageListResponse result = new PageListResponse();
        // 获取列表
        result.setList(page.getRecords());
        // 获取总数
        result.setTotal(page.getTotal());
        return result;
    }

    // 更新职位信息
    public Boolean updateJobInfo(Job params){
        // 根据主键ID更新职位信息，返回更新成功个数
        int count = jobMapper.updateById(params);
        return count > 0;
    }
    // 删除职位
    public Boolean deleteJob(String id){
        int count = jobMapper.deleteById(id);
        return count > 0;
    }
    // 发布新职位
    public Boolean addJob(Job params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置职位ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = jobMapper.insert(params);
        return count > 0;
    }

}
