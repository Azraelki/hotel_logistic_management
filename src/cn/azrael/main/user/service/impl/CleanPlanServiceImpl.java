package cn.azrael.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.user.dao.CleanPlanDao;
import cn.azrael.main.user.entity.CleanPlan;
import cn.azrael.main.user.service.CleanPlanService;
@Service("cleanPlanService")
public class CleanPlanServiceImpl extends BaseServiceImpl<CleanPlan> implements CleanPlanService{
	private CleanPlanDao cleanPlanDao;
	@Resource
	public void setCleanPlanDao(CleanPlanDao cleanPlanDao) {
		setBaseDao(cleanPlanDao);
		this.cleanPlanDao = cleanPlanDao;
	}
}
