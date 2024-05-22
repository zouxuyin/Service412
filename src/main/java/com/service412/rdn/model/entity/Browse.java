package com.service412.rdn.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.service412.rdn.handler.DateTypeHandler;
import com.service412.rdn.model.enums.BrowseTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 浏览信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "浏览信息",description = "")
@TableName(autoResultMap = true)
public class Browse implements Serializable,Cloneable{
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 数据ID */
    @ApiModelProperty(name = "数据ID",notes = "")
    private String dataId ;
    /** 类型 */
    @ApiModelProperty(name = "类型",notes = "")
    private BrowseTypeEnum type ;
    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
}
