package cn.azrael.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.user.dao.JobDao;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.service.JobService;
@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService{
	private JobDao jobDao;
	@Resource
	public void setJobDao(JobDao jobDao) {
		this.setBaseDao(jobDao);
		this.jobDao = jobDao;
	}
}
