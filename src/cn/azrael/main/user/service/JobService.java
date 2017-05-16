package cn.azrael.main.user.service;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.user.entity.Job;

public interface JobService extends BaseService<Job>{
	//删除职务并删除权限
	public void deleteAndRole(int id)throws ServiceException;
}
