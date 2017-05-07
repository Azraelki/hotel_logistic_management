package cn.azrael.main.facilitie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.facilitie.dao.FacilitieFixDao;
import cn.azrael.main.facilitie.entity.FacilitieFix;
import cn.azrael.main.facilitie.service.FacilitieFixService;
@Service("facilitieFixService")
public class FacilitieFixServiceImpl extends BaseServiceImpl<FacilitieFix> implements FacilitieFixService{
	private FacilitieFixDao facilitieFixDao;
	@Resource
	public void setFacilitieFixDao(FacilitieFixDao facilitieFixDao) {
		setBaseDao(facilitieFixDao);
		this.facilitieFixDao = facilitieFixDao;
	}

}
