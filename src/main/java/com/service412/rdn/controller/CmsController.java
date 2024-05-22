package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.GetCmsListRequest;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.enums.CmsTypeEnum;
import com.service412.rdn.model.entity.Cms;
import com.service412.rdn.service.CmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 系统内容信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "System Content Management")
@RestController
@RequestMapping("/cms")
public class CmsController {
    @Resource
    private CmsService cmsService;

    @ApiOperation(value = "获取系统内容")
    @PostMapping("/getCmsList")
    public BaseResponse<PageListResponse<Cms>> getCmsList(@RequestBody GetCmsListRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        CmsTypeEnum type = params.getType();
        PageListResponse<Cms> result = cmsService.getCmsList(current, pageSize, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "新增系统内容")
    @PostMapping("/addCms")
    public BaseResponse<Boolean> addCms(@RequestBody Cms params){
        Boolean result = cmsService.addCms(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "更新系统内容")
    @PostMapping("/updateCms")
    public BaseResponse<Boolean> updateCms(@RequestBody Cms params){
        Boolean result = cmsService.updateCms(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "删除系统内容")
    @DeleteMapping("/deleteCms/{id}")
    public BaseResponse<Boolean> deleteCms(@PathVariable("id") String id){
        Boolean result = cmsService.deleteCms(id);
        return ResultUtils.success(result);
    }

}
