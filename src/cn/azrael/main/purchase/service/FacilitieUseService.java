package cn.azrael.main.purchase.service;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.purchase.entity.FacilitieUse;

public interface FacilitieUseService extends BaseService<FacilitieUse>{
	//添加消耗并更新设施
	public void addAndEditFacilitie(FacilitieUse facilitieUse)throws ServiceException;
	//删除消耗并更新设施
	public void deleteAndEditFacilitie(FacilitieUse facilitieUse)throws ServiceException;
	//更新消耗并更新设施
	public void editAndEditFacilitie(FacilitieUse facilitieUse)throws ServiceException;
}
