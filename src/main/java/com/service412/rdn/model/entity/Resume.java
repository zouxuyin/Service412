package com.service412.rdn.model.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.service412.rdn.handler.DateTypeHandler;
import com.service412.rdn.model.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 简历信息;
 * @author : One Direction
 * @date : 2022-12-13
 */
@Data
@ApiModel(value = "简历信息",description = "")
@TableName(autoResultMap = true)
public class Resume implements Serializable,Cloneable {
    /** 主键 */
    @ApiModelProperty(name = "主键", notes = "")
    @TableId
    private String id;
    /** 用户id */
    @ApiModelProperty(name = "用户id", notes = "")
    private String userId;
    /** 出生日期 */
    @ApiModelProperty(name = "出生日期", notes = "")
    private String birthday;
    /** 姓名 */
    @ApiModelProperty(name = "姓名", notes = "")
    private String name;
    /** 性别 */
    @ApiModelProperty(name = "性别", notes = "")
    private GenderEnum gender;
    /** 最高学历 */
    @ApiModelProperty(name = "最高学历", notes = "")
    private EducationEnum education;
    /** 工作经历 */
    @ApiModelProperty(name = "工作经验", notes = "")
    private ExperienceEnum experience;
    /** 个人特长 */
    @ApiModelProperty(name = "个人特长", notes = "")
    private String skill;
    /** 求职状态 */
    @ApiModelProperty(name = "求职状态", notes = "")
    private JobStatusEnum jobStatus;
    /** 期望薪资 */
    @ApiModelProperty(name = "期望薪资", notes = "")
    private SalaryEnum salary;
    /** 期望职位 */
    @ApiModelProperty(name = "期望职位", notes = "")
    private String postId;
    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = DateTypeHandler.class)
    @ApiModelProperty(name = "创建时间", notes = "")
    private Date createTime;

}