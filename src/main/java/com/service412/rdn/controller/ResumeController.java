package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.PageRequest;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.GetResumeListRequest;
import com.service412.rdn.model.entity.Resume;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.vo.ResumeVo;
import com.service412.rdn.service.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 个人简历信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Resume Information Management")
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @ApiOperation(value = "Obtain User Resume")
    @GetMapping("/getUserResume")
    public BaseResponse<Resume> getUserResume(HttpServletRequest request) {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        Resume result = resumeService.getUserResume(token);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Resume Information")
    @PostMapping("/updateResumeInfo")
    public BaseResponse<Boolean> updateResume(@RequestBody Resume params){
        Boolean result = resumeService.updateResume(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get Resume List")
    @PostMapping("/getResumeList")
    public BaseResponse<PageListResponse<ResumeVo>> getResumeList(@RequestBody GetResumeListRequest params){
        String keyword = params.getKeyword();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<ResumeVo> result = resumeService.getResumeList(current, pageSize, keyword);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get Resume Information")
    @GetMapping("/getResumeInfo/{id}")
    public BaseResponse<ResumeVo> getResumeInfo(@PathVariable("id") String id) {
        ResumeVo result = resumeService.getResumeInfo(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Add Resume Information")
    @PostMapping("/addResume")
    public BaseResponse<Boolean> addResume(@RequestBody Resume params){
        Boolean result = resumeService.addResume(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete Resume Information")
    @DeleteMapping("/deleteResume/{id}")
    public BaseResponse<Boolean> deleteResume(@PathVariable("id") String id){
        Boolean result = resumeService.deleteResume(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Administrator Obtains Resume List")
    @PostMapping("/getList")
    public BaseResponse<PageListResponse<Resume>> getList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<Resume> result = resumeService.getList(current, pageSize);
        return ResultUtils.success(result);
    }

}
