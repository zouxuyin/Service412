package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Position;

public interface PositionService {

    PageListResponse getPositionList(long current, long pageSize);

    Boolean deletePosition(String id);

    Boolean addPosition(Position params);

    Boolean updatePosition(Position params);
}
