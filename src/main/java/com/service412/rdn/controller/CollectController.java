package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.*;
import com.service412.rdn.model.enums.CollectTypeEnum;
import com.service412.rdn.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 收藏信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Collection Inforamtion Management")
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @ApiOperation(value = "Add Collection Information")
    @PostMapping("/addCollect")
    public BaseResponse<Boolean> addCollect(@RequestBody AddCollectRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        CollectTypeEnum type = params.getType();
        Boolean result = collectService.addCollect(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Cancel Collection Information")
    @PostMapping("/deleteCollect")
    public BaseResponse<Boolean> deleteCollect(@RequestBody DeleteCollectRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        CollectTypeEnum type = params.getType();
        Boolean result = collectService.deleteCollect(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Whether to bookmark")
    @PostMapping("/isCollect")
    public BaseResponse<Boolean> isCollect(@RequestBody IsCollectRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        CollectTypeEnum type = params.getType();
        Boolean result = collectService.isCollect(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get Favorite Information")
    @PostMapping("/getCollectList")
    public <T> T getCollectList(@RequestBody GetCollectListRequest params){
        String userId = params.getUserId();
        CollectTypeEnum type = params.getType();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<T> result = collectService.getCollectList(current, pageSize, userId, type);
        return (T) ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Favorite Information")
    @DeleteMapping("/deleteCollect/{id}")
    public BaseResponse<Boolean> delete(@PathVariable("id") String id){
        Boolean result = collectService.delete(id);
        return ResultUtils.success(result);
    }

}

