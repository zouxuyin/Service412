package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.PageRequest;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Position;
import com.service412.rdn.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 职位信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Job Information Management")
@RestController
@RequestMapping("/position")
public class PositionController {
    @Resource
    private PositionService positionService;

    @ApiOperation(value = "Get Job List")
    @PostMapping("/getPositionList")
    public BaseResponse<PageListResponse<Position>> getPositionList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Position> result = positionService.getPositionList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Add Job Information")
    @PostMapping("/addPosition")
    public BaseResponse<Boolean> addPosition(@RequestBody Position params){
        Boolean result = positionService.addPosition(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Job Information")
    @PostMapping("/updatePosition")
    public BaseResponse<Boolean> updatePosition(@RequestBody Position params){
        Boolean result = positionService.updatePosition(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Job Information")
    @DeleteMapping("/deletePosition/{id}")
    public BaseResponse<Boolean> deletePosition(@PathVariable("id") String id){
        Boolean result = positionService.deletePosition(id);
        return ResultUtils.success(result);
    }

}
