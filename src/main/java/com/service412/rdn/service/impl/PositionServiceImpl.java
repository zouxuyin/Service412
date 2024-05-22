package com.service412.rdn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.mapper.PositionMapper;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Position;
import com.service412.rdn.service.PositionService;
import com.service412.rdn.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper postMapper;


    public PageListResponse getPositionList(long current, long pageSize){
        // 分页查询
        Page<Position> page = postMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    // 删除岗位
    public Boolean deletePosition(String id){
        int count = postMapper.deleteById(id);
        return count > 0;
    }

    // 新增岗位
    public Boolean addPosition(Position params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置用户ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = postMapper.insert(params);
        return count > 0;
    }

    // 更新岗位
    public Boolean updatePosition(Position params){
        int count = postMapper.updateById(params);
        return count > 0;
    }
}
