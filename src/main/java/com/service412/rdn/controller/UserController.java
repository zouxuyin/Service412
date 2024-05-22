package com.service412.rdn.controller;

import com.service412.rdn.common.PageRequest;
import com.service412.rdn.model.vo.UserInfoVo;
import com.service412.rdn.model.dto.*;
import com.service412.rdn.model.entity.User;
import com.service412.rdn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import com.service412.rdn.common.BaseResponse;
import com.service412.rdn.common.ResultUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息
 * @author : One Direction
 * @date : 2022-11-18
 */
@Api(tags = "User Account Management")
@RestController
@RequestMapping("/user")
public class UserController{
    @Resource
    private UserService userService;


    @ApiOperation(value = "Get User Information")
    @GetMapping("/getUserInfo")
    public BaseResponse<UserInfoVo> getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        User result = userService.getUserInfo(token);
        UserInfoVo UserInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(result, UserInfoVo);
        return ResultUtils.success(UserInfoVo);
    }

    @ApiOperation(value = "Get User OpenId")
    @GetMapping("/getOpenId")
    public BaseResponse<GetOpenIdResponse> getOpenId(String codeId){
        GetOpenIdResponse result = userService.getOpenId(codeId);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Mini Program Authorization Login")
    @PostMapping("/wxUserLogin")
    public BaseResponse<WxUserLoginResponse> wxUserLogin(@RequestBody WxUserLoginRequest wxUserLoginRequest){
        String openId = wxUserLoginRequest.getOpenid();
        String avatar = wxUserLoginRequest.getAvatar();
        String username = wxUserLoginRequest.getNickName();
        WxUserLoginResponse result = userService.wxUserLogin(openId,username,avatar);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Switch User Role")
    @PostMapping("/switchRole")
    public BaseResponse<Boolean> switchRole(@RequestBody SwitchRoleRequest switchRoleRequest){
        String id = switchRoleRequest.getId();
        String role = switchRoleRequest.getRole();
        boolean result = userService.switchRole(id, role);
        return ResultUtils.success(result);
    }


    @ApiOperation(value = "Account Password Login")
    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginRequest LoginRequest){
        String username = LoginRequest.getUsername();
        String password = LoginRequest.getPassword();
        LoginResponse result = userService.login(username,password);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Get User List")
    @PostMapping("/getUserList")
    public BaseResponse<PageListResponse<User>> getUserList(@RequestBody PageRequest params){
        long current = params.getCurrent();
        long pageSize = params.getPageSize();
        PageListResponse<User> result = userService.getUserList(current, pageSize);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Add User Information")
    @PostMapping("/addUser")
    public BaseResponse<Boolean> addUser(@RequestBody User params){
        Boolean result = userService.addUser(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Update User Information")
    @PostMapping("/updateUser")
    public BaseResponse<Boolean> updateUser(@RequestBody User params){
        Boolean result = userService.updateUser(params);
        return ResultUtils.success(result);
    }

    @ApiOperation(value = "Delete User Information")
    @DeleteMapping("/deleteUser/{id}")
    public BaseResponse<Boolean> deleteUser(@PathVariable("id") String id){
        Boolean result = userService.deleteUser(id);
        return ResultUtils.success(result);
    }


}
