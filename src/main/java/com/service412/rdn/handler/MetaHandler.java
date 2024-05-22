package com.service412.rdn.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.service412.rdn.model.enums.UserRoleEnum;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 插入操作时，添加默认数据
        this.fillStrategy(metaObject,"role", UserRoleEnum.DEFAULT);
        this.fillStrategy(metaObject,"enableStatus", false);
        this.fillStrategy(metaObject,"updateTime", new Date());
        this.fillStrategy(metaObject,"registerDate", new Date());
        this.fillStrategy(metaObject,"createTime", new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {// 更新操作时 添加默认数据
        this.fillStrategy(metaObject,"updateTime", new Date());
    }

}
