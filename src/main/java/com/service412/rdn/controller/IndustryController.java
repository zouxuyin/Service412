package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.PageRequest;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Industry;
import com.service412.rdn.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 行业信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Industry Information Management")
@RestController
@RequestMapping("/industry")
public class IndustryController {
    @Resource
    private IndustryService industryService;

    @ApiOperation(value = "Get Industry List")
    @PostMapping("/getIndustryList")
    public BaseResponse<PageListResponse<Industry>> getIndustryList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Industry> result = industryService.getIndustryList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "New Industry Information Added")
    @PostMapping("/addIndustry")
    public BaseResponse<Boolean> addIndustry(@RequestBody Industry params){
        Boolean result = industryService.addIndustry(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Industry Information")
    @PostMapping("/updateIndustry")
    public BaseResponse<Boolean> updateIndustry(@RequestBody Industry params){
        Boolean result = industryService.updateIndustry(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Industry Information")
    @DeleteMapping("/deleteIndustry/{id}")
    public BaseResponse<Boolean> deleteIndustry(@PathVariable("id") String id){
        Boolean result = industryService.deleteIndustry(id);
        return ResultUtils.success(result);
    }

}
