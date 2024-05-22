package com.service412.rdn.model.dto;

import com.service412.rdn.common.PageRequest;
import com.service412.rdn.model.enums.BrowseTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetBrowseListRequest extends PageRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 类型
     */
    private BrowseTypeEnum type;
}
