package com.service412.rdn.service;

import com.service412.rdn.model.dto.LoginResponse;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.User;
import com.service412.rdn.model.dto.GetOpenIdResponse;
import com.service412.rdn.model.dto.WxUserLoginResponse;

/**
 * 用户信息;(user)表服务接口
 * @author : One Direction
 * @date : 2022-11-18
 */
public interface UserService{

    User getUserInfo(String token);

    GetOpenIdResponse getOpenId(String codeId);

    WxUserLoginResponse wxUserLogin(String openId, String username, String avatar);

    boolean switchRole(String id, String role);

    LoginResponse login(String username, String password);

    PageListResponse getUserList(long current, long pageSize);

    Boolean deleteUser(String id);

    Boolean addUser(User params);

    Boolean updateUser(User params);


}