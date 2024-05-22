package com.service412.rdn.model.dto;

import com.service412.rdn.model.enums.CollectTypeEnum;
import lombok.Data;
import java.io.Serializable;

@Data
public class AddCollectRequest implements Serializable {
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
    private CollectTypeEnum type;
}
