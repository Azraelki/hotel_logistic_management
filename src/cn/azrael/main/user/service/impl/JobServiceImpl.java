package cn.azrael.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.user.dao.JobDao;
import cn.azrael.main.user.dao.RoleDao;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.service.JobService;
@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService{
	private JobDao jobDao;
	private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Resource
	public void setJobDao(JobDao jobDao) {
		this.setBaseDao(jobDao);
		this.jobDao = jobDao;
	}
	@Override
	public void deleteAndRole(int id) {
		jobDao.delete(id);
		roleDao.deleteByType(id);
	}
}
