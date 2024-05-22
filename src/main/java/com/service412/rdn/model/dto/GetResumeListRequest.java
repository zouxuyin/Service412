package com.service412.rdn.model.dto;

import com.service412.rdn.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetResumeListRequest extends PageRequest implements Serializable {
    /**
     * job_name
     */
    private String keyword;

}
