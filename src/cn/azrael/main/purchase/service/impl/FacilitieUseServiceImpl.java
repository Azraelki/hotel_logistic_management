package cn.azrael.main.purchase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.purchase.dao.FacilitieUseDao;
import cn.azrael.main.purchase.entity.FacilitieUse;
import cn.azrael.main.purchase.service.FacilitieUseService;
@Service("facilitieUseService")
public class FacilitieUseServiceImpl extends BaseServiceImpl<FacilitieUse> implements FacilitieUseService{
	private FacilitieUseDao facilitieUseDao;
	@Resource
	public void setFacilitieUseDao(FacilitieUseDao facilitieUseDao) {
		setBaseDao(facilitieUseDao);
		this.facilitieUseDao = facilitieUseDao;
	}
}
