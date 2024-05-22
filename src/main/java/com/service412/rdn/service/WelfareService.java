package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Welfare;

public interface WelfareService {

    PageListResponse getWelfareList(long current, long pageSize);

    Boolean deleteWelfare(String id);

    Boolean addWelfare(Welfare params);

    Boolean updateWelfare(Welfare params);
}
