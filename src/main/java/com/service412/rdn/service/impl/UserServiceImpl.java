package com.service412.rdn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.model.dto.LoginResponse;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.constant.WXConfigConstant;
import com.service412.rdn.model.dto.WxUserLoginResponse;
import com.service412.rdn.model.entity.User;
import com.service412.rdn.model.enums.UserRoleEnum;
import com.service412.rdn.service.UserService;
import com.service412.rdn.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson2.JSONObject;
import com.service412.rdn.model.dto.GetOpenIdResponse;
import com.service412.rdn.mapper.UserMapper;
import com.service412.rdn.common.ErrorCode;
import com.service412.rdn.exception.BusinessException;
import com.service412.rdn.config.JwtConfig;


/**
 * 用户信息;(user)表服务实现类
 * @author : One Direction
 * @date : 2022-11-18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 盐值，混淆密码
     */
    private static final String SALT = "one";


    public User getUserInfo(String token){
        String id = JwtConfig.getTokenInfo(token).getClaim("id").asString();
        return userMapper.selectById(id);
    }

    public GetOpenIdResponse getOpenId(String codeId){
        RestTemplate restTemplate = new RestTemplate();
        String url = WXConfigConstant.CODE_URL + WXConfigConstant.APP_ID +
                "&secret=" + WXConfigConstant.SECRET +
                "&js_code=" + codeId +
                "&grant_type=authorization_code";

        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(res.getBody());
        Object openId = jsonObject.get("openid");
        // codeId已被使用
        if (openId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "codeId已失效");
        }
        GetOpenIdResponse result = new GetOpenIdResponse();
        result.setOpenid(jsonObject.get("openid").toString());
        result.setSession_key(jsonObject.get("session_key").toString());
        return result;
    }

    public WxUserLoginResponse wxUserLogin(String openId, String username, String avatar) {
        // 判断是否存在该用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        User userInfo = userMapper.selectOne(queryWrapper);
        String id = null;
        // 用户不存在插入数据库
        if (userInfo == null) {
            User user = new User();
            id = new UuidUtils().getShortUuid();
            user.setId(id);
            user.setOpenId(openId);
            user.setUsername(username);
            user.setAvatar(avatar);
            userMapper.insert(user);
        }else{
          id = userInfo.getId();
        }
        String token = JwtConfig.sign(openId, id);
        WxUserLoginResponse result = new WxUserLoginResponse();
        result.setToken(token);
        return result;
    }

    public boolean switchRole(String id, String role){
        User user = userMapper.selectById(id);
        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        // 判断用户当前的角色
        UserRoleEnum roleValue = UserRoleEnum.valueOf(role);
        UserRoleEnum userRole = userMapper.selectById(id).getRole();
        if(roleValue != userRole){
            User updateRole = new User();
            updateRole.setId(id);
            updateRole.setRole(roleValue);
            int total = userMapper.updateById(updateRole);
            return total > 0;
        }else{
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
    }


    public LoginResponse login(String username, String password){
        // 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        String id = user.getId();
        String token = JwtConfig.sign("",id);
        LoginResponse result = new LoginResponse();
        result.setToken(token);
        return result;
    }

    public PageListResponse getUserList(long current, long pageSize){
        // 分页查询
        Page<User> page = userMapper.selectPage(new Page<>(current, pageSize), null);
        PageListResponse result = new PageListResponse();
        result.setList(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }


    // 删除用户
    public Boolean deleteUser(String id){
        int count = userMapper.deleteById(id);
        return count > 0;
    }

    // 新增用户
    public Boolean addUser(User params){
        // 生成uuid
        String id = new UuidUtils().getShortUuid();
        // 设置用户ID
        params.setId(id);
        // 执行插入语句，返回插入成功个数
        int count = userMapper.insert(params);
        return count > 0;
    }

    // 更新用户
    public Boolean updateUser(User params){
        int count = userMapper.updateById(params);
        return count > 0;
    }


}
