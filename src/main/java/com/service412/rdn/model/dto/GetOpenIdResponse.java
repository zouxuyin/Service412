package com.service412.rdn.model.dto;

import java.io.Serializable;
import lombok.Data;
@Data
public class GetOpenIdResponse implements Serializable {
    /**
     * openid
     */
    private String openid;

    /**
     * session_key
     */
    private String session_key;
}
