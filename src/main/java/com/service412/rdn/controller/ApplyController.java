package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.*;
import com.service412.rdn.model.enums.ApplyTypeEnum;
import com.service412.rdn.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 应聘信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Job Application Information management")
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @ApiOperation(value = "Add Job Application Information")
    @PostMapping("/addApply")
    public BaseResponse<Boolean> addApply(@RequestBody AddApplyRequest params){
        String userId =  params.getUserId();
        String jobId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.addApply(userId, jobId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Cancel Application Information")
    @PostMapping("/deleteApply")
    public BaseResponse<Boolean> deleteApply(@RequestBody DeleteApplyRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.deleteApply(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Whether to Apply or Not")
    @PostMapping("/isApply")
    public BaseResponse<Boolean> isApply(@RequestBody IsApplyRequest params){
        String userId =  params.getUserId();
        String dataId = params.getDataId();
        ApplyTypeEnum type = params.getType();
        Boolean result = applyService.isApply(userId, dataId, type);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Obtain Job Application Information")
    @PostMapping("/getApplyList")
    public <T> T getApplyList(@RequestBody GetApplyListRequest params){
        String userId = params.getUserId();
        ApplyTypeEnum type = params.getType();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<T> result = applyService.getApplyList(current, pageSize, userId, type);
        return (T) ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Application Information")
    @DeleteMapping("/deleteApply/{id}")
    public BaseResponse<Boolean> delete(@PathVariable("id") String id){
        Boolean result = applyService.delete(id);
        return ResultUtils.success(result);
    }


}
