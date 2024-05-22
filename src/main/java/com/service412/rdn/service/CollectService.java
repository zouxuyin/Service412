package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.enums.CollectTypeEnum;

public interface CollectService {
  Boolean addCollect(String userId, String dataId, CollectTypeEnum type);

  Boolean deleteCollect(String userId, String dataId, CollectTypeEnum type);

  Boolean isCollect(String userId, String dataId, CollectTypeEnum type);

  PageListResponse getCollectList(long current, long pageSize, String userId, CollectTypeEnum type);

  Boolean delete(String id);

}
