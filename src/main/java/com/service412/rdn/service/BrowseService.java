package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.enums.BrowseTypeEnum;

public interface BrowseService {

    Boolean addBrowse(String userId, String dataId, BrowseTypeEnum type);

    PageListResponse getBrowseList(long current, long pageSize, String userId, BrowseTypeEnum type);

    Boolean deleteBrowse(String id);

}
