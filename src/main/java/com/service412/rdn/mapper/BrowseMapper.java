package com.service412.rdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service412.rdn.model.entity.Browse;
import com.service412.rdn.model.enums.BrowseTypeEnum;
import com.service412.rdn.model.vo.BrowseVo;
import com.service412.rdn.model.vo.CompanyInfoVo;
import com.service412.rdn.model.vo.ResumeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BrowseMapper extends BaseMapper<Browse>{

    @Select("SELECT c.id,c.name,c.full_name,c.logo,c.nature,c.staff_size,c.introduce,c.address,c.auth_id,c.work_time,c.rest_time,c.work_overtime,c.enable_status,c.create_time,c.update_time,i.name industry_name from browse b, company c,industry i " +
            "where b.user_id = #{user_id} and b.type = #{type} and b.data_id = c.id and c.industry_id = i.id")
    Page<CompanyInfoVo> getLLGWList(Page<CompanyInfoVo> page, @Param("user_id") String userId, @Param("type") BrowseTypeEnum type);

    @Select("SELECT r.id, r.birthday, r.name, r.gender, r.education, r.experience, r.skill, r.job_status, r.salary, r.post_id, r.create_time, u.username, u.mobile, u.avatar user_avatar, p.name post_name from user u,browse b,resume r,position p " +
            "where b.user_id = #{user_id} and b.type = #{type} and b.data_id = r.id and r.post_id = p.id and r.user_id = u.id")
    Page<ResumeVo> getLLJLList(Page<ResumeVo> page, @Param("user_id") String userId, @Param("type") BrowseTypeEnum type);

    @Select("SELECT b.id, u.username, c.name, b.type, b.create_time from user u, browse b, company c " +
            "where b.type = #{type} and b.data_id = c.id and u.id = b.user_id")
    Page<BrowseVo> getLLGW(Page<BrowseVo> page, @Param("type") BrowseTypeEnum type);

    @Select("SELECT b.id, u.username, r.name, b.type, b.create_time from user u, browse b, resume r " +
            "where b.type = #{type} and b.data_id = r.id and u.id = b.user_id")
    Page<BrowseVo> getLLJL(Page<BrowseVo> page, @Param("type") BrowseTypeEnum type);

}
