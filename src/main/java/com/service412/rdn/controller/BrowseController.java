package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.AddBrowseRequest;
import com.service412.rdn.model.enums.BrowseTypeEnum;
import com.service412.rdn.service.BrowseService;
import com.service412.rdn.model.dto.GetBrowseListRequest;
import com.service412.rdn.model.dto.PageListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 浏览信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Browsing Information Management")
@RestController
@RequestMapping("/browse")
public class BrowseController {
    @Resource
    private BrowseService browseService;

    @ApiOperation(value = "Add Browsing Information")
    @PostMapping("/addBrowse")
    public BaseResponse<Boolean> addBrowse(@RequestBody AddBrowseRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        BrowseTypeEnum type = params.getType();
        Boolean result = browseService.addBrowse(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get Browsing List")
    @PostMapping("/getBrowseList")
    public <T> T getBrowseList(@RequestBody GetBrowseListRequest params){
        String userId = params.getUserId();
        BrowseTypeEnum type = params.getType();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<T> result = browseService.getBrowseList(current, pageSize, userId, type);
        return (T) ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Browing Information")
    @DeleteMapping("/deleteBrowse/{id}")
    public BaseResponse<Boolean> deleteBrowse(@PathVariable("id") String id){
        Boolean result = browseService.deleteBrowse(id);
        return ResultUtils.success(result);
    }
}

