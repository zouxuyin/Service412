package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.GetJobListRequest;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Job;
import com.service412.rdn.model.vo.JobInfoVo;
import com.service412.rdn.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 工作信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Work Information Management")
@RestController
@RequestMapping("/job")
public class JobController {
    @Resource
    private JobService jobService;

    @ApiOperation(value = "Add Job Information")
    @PostMapping("/addJob")
    public BaseResponse<Boolean> addJob(@RequestBody Job params){
        Boolean result = jobService.addJob(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get WorkList")
    @PostMapping("/getJobList")
    public BaseResponse<PageListResponse<JobInfoVo>> getJobList(@RequestBody GetJobListRequest params, HttpServletRequest request){
        String jobName = params.getJobName();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        String token = request.getHeader("token");
        PageListResponse<JobInfoVo> result = jobService.getJobList(current, pageSize, jobName, token);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Work Information")
    @PostMapping("/updateJobInfo")
    public BaseResponse<Boolean> updateJobInfo(@RequestBody Job params){
        Boolean result = jobService.updateJobInfo(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Work Information")
    @DeleteMapping("/deleteJob/{id}")
    public BaseResponse<Boolean> deleteJob(@PathVariable("id") String id){
        Boolean result = jobService.deleteJob(id);
        return ResultUtils.success(result);
    }


}
