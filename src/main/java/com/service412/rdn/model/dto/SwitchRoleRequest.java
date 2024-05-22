package com.service412.rdn.model.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SwitchRoleRequest implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 角色
     */
    private String role;
}
