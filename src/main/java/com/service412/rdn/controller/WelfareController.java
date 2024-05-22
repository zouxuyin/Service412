package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.PageRequest;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Welfare;
import com.service412.rdn.service.WelfareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 福利信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Welfare Information Management")
@RestController
@RequestMapping("/welfare")
public class WelfareController {
    @Resource
    private WelfareService welfareService;

    @ApiOperation(value = "Get Welfare List")
    @PostMapping("/getWelfareList")
    public BaseResponse<PageListResponse<Welfare>> getWelfareList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Welfare> result = welfareService.getWelfareList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "New Welfare Informatin")
    @PostMapping("/addWelfare")
    public BaseResponse<Boolean> addWelfare(@RequestBody Welfare params){
        Boolean result = welfareService.addWelfare(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Welfare Information")
    @PostMapping("/updateWelfare")
    public BaseResponse<Boolean> updateWelfare(@RequestBody Welfare params){
        Boolean result = welfareService.updateWelfare(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Welfare Information")
    @DeleteMapping("/deleteWelfare/{id}")
    public BaseResponse<Boolean> deleteWelfare(@PathVariable("id") String id){
        Boolean result = welfareService.deleteWelfare(id);
        return ResultUtils.success(result);
    }

}
