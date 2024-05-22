package com.service412.rdn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.mapper.IndustryMapper;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Industry;
import com.service412.rdn.service.IndustryService;
import com.service412.rdn.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryMapper industryMapper;


    public PageListResponse getIndustryList(long current, long pageSize){
        // 分页查询
        Page<Industry> page = industryMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }
    // 删除行业
    public Boolean deleteIndustry(String id){
        int count = industryMapper.deleteById(id);
        return count > 0;
    }

    // 新增行业
    public Boolean addIndustry(Industry params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置用户ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = industryMapper.insert(params);
        return count > 0;
    }

    // 更新行业
    public Boolean updateIndustry(Industry params){
        int count = industryMapper.updateById(params);
        return count > 0;
    }
}
