package com.service412.rdn.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable{
    /**
     * token
     */
    private String token;
}
