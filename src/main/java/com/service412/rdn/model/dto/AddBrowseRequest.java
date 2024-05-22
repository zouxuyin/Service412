package com.service412.rdn.model.dto;

import com.service412.rdn.model.enums.BrowseTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddBrowseRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * 类型
     */
    private BrowseTypeEnum type;
}
