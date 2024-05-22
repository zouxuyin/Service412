package com.service412.rdn.model.dto;

import com.service412.rdn.common.PageRequest;
import com.service412.rdn.model.enums.CmsTypeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetCmsListRequest extends PageRequest implements Serializable {
    /**
     * 类型
     */
    private CmsTypeEnum type;
}
