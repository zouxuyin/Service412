package com.service412.rdn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.mapper.CmsMapper;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Cms;
import com.service412.rdn.model.enums.CmsTypeEnum;
import com.service412.rdn.service.CmsService;
import com.service412.rdn.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmsServiceImpl implements CmsService {
    @Autowired
    private CmsMapper cmsMapper;


    public PageListResponse getCmsList(long current, long pageSize, CmsTypeEnum type){
        // 分页查询
        QueryWrapper<Cms> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        Page<Cms> page = cmsMapper.selectPage(new Page<>(current, pageSize), queryWrapper);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    // 删除系统内容
    public Boolean deleteCms(String id){
        int count = cmsMapper.deleteById(id);
        return count > 0;
    }

    // 新增系统内容
    public Boolean addCms(Cms params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置用户ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = cmsMapper.insert(params);
        return count > 0;
    }

    // 更新系统内容
    public Boolean updateCms(Cms params){
        int count = cmsMapper.updateById(params);
        return count > 0;
    }
}
