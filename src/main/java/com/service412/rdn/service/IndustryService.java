package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Industry;

public interface IndustryService {

    PageListResponse getIndustryList(long current, long pageSize);

    Boolean deleteIndustry(String id);

    Boolean addIndustry(Industry params);

    Boolean updateIndustry(Industry params);
}
