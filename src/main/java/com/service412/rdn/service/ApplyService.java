package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.enums.ApplyTypeEnum;

public interface ApplyService {
    Boolean addApply(String userId, String dataId, ApplyTypeEnum type);

    Boolean deleteApply(String userId, String dataId, ApplyTypeEnum type);

    Boolean isApply(String userId, String dataId, ApplyTypeEnum type);

    PageListResponse getApplyList(long current, long pageSize, String userId, ApplyTypeEnum type);

    Boolean delete(String id);

}
