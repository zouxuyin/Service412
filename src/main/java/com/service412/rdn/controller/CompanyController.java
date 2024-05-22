package com.service412.rdn.controller;

import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.PageRequest;
import com.service412.rdn.common.ResultUtils;
import com.service412.rdn.model.dto.GetCompanyJobRequest;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Company;
import com.service412.rdn.model.vo.CompanyInfoVo;
import com.service412.rdn.model.vo.JobInfoVo;
import com.service412.rdn.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 公司信息;
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "Company Information Mannagement")
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @ApiOperation(value = "Get Company List")
    @PostMapping("/getCompanyList")
    public BaseResponse<PageListResponse<CompanyInfoVo>> getCompanyList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<CompanyInfoVo> result = companyService.getCompanyList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Obtain Company positions")
    @PostMapping("/getCompanyJob")
    public BaseResponse<PageListResponse<JobInfoVo>> getCompanyJob(@RequestBody GetCompanyJobRequest params){
        String id =  params.getId();
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<JobInfoVo> result = companyService.getCompanyJob(id,current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get Company Information")
    @GetMapping("/getCompanyInfo/{id}")
    public BaseResponse<CompanyInfoVo> getCompanyInfo(@PathVariable("id") String id){
        CompanyInfoVo result = companyService.getCompanyInfo(id);
        return ResultUtils.success(result);
    }

    // 管理员新增公司信息
    @ApiOperation(value = "Add Company Information")
    @PostMapping("/addCompanyInfo")
    public BaseResponse<Boolean> addCompanyInfo(@RequestBody Company params){
        Boolean result = companyService.addCompanyInfo(params);
        return ResultUtils.success(result);
    }

    // 删除公司信息
    @ApiOperation(value = "Delete Company Information")
    @DeleteMapping("/deleteCompany/{id}")
    public BaseResponse<Boolean> deleteCompany(@PathVariable("id") String id){
        Boolean result = companyService.deleteCompany(id);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update Company Information")
    @PostMapping("/updateCompanyInfo")
    public BaseResponse<Boolean> updateCompanyInfo(@RequestBody Company params){
        Boolean result = companyService.updateCompanyInfo(params);
        return ResultUtils.success(result);
    }

    // 招聘者新增公司信息
    @ApiOperation(value = "Recruiter adds new company information")
    @PostMapping("/addCompany")
    public BaseResponse<Boolean> addCompany(@RequestBody Company params, HttpServletRequest request){
        String token = request.getHeader("token");
        Boolean result = companyService.addCompany(params,token);
        return ResultUtils.success(result);
    }

}
