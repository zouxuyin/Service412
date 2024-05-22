package com.service412.rdn.service;

import com.service412.rdn.model.entity.Cms;
import com.service412.rdn.model.enums.CmsTypeEnum;
import com.service412.rdn.model.dto.PageListResponse;

public interface CmsService {

    PageListResponse getCmsList(long current, long pageSize, CmsTypeEnum type);

    Boolean deleteCms(String id);

    Boolean addCms(Cms params);

    Boolean updateCms(Cms params);
}
