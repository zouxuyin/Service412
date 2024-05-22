package com.service412.rdn.service;

import com.service412.rdn.model.entity.Resume;
import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.vo.ResumeVo;

/**
 * 个人简历信息;(person_resume)表服务接口
 * @author : One Direction
 * @date : 2022-12-13
 */
public interface ResumeService{

    Resume getUserResume(String token);

    Boolean updateResume(Resume params);

    PageListResponse getResumeList(long current, long pageSize, String keyword);

    ResumeVo getResumeInfo(String id);

    Boolean addResume(Resume params);

    Boolean deleteResume(String id);

    PageListResponse getList(long current, long pageSize);
}
