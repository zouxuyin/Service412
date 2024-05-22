package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Company;
import com.service412.rdn.model.vo.CompanyInfoVo;

public interface CompanyService {

    PageListResponse getCompanyList(long current, long pageSize);

    PageListResponse getCompanyJob(String id,long current, long pageSize);

    CompanyInfoVo getCompanyInfo(String id);

    Boolean updateCompanyInfo(Company params);

    Boolean addCompanyInfo(Company params);

    Boolean deleteCompany(String id);

    Boolean addCompany(Company params,String token);
}
