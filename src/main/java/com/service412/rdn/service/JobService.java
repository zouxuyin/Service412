package com.service412.rdn.service;

import com.service412.rdn.model.dto.PageListResponse;
import com.service412.rdn.model.entity.Job;

public interface JobService {

    PageListResponse getJobList(long current, long pageSize, String jobName, String token);

    Boolean updateJobInfo(Job params);

    Boolean deleteJob(String id);

    Boolean addJob(Job params);

}
