package com.service412.rdn.model.dto;

import com.service412.rdn.common.PageRequest;
import com.service412.rdn.model.enums.ApplyTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetApplyListRequest extends PageRequest implements Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 类型
     */
    private ApplyTypeEnum type;
}
