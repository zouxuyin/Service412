package com.service412.rdn.model.dto;

import com.service412.rdn.common.PageRequest;
import lombok.Data;
import java.io.Serializable;

@Data
public class GetCompanyJobRequest extends PageRequest implements Serializable {
    /**
     * company_id
     */
    private String id;

}
