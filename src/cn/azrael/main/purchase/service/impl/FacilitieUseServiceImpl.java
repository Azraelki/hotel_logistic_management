package cn.azrael.main.purchase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.facilitie.dao.FacilitieDao;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.purchase.dao.FacilitieUseDao;
import cn.azrael.main.purchase.entity.FacilitieUse;
import cn.azrael.main.purchase.service.FacilitieUseService;
@Service("facilitieUseService")
public class FacilitieUseServiceImpl extends BaseServiceImpl<FacilitieUse> implements FacilitieUseService{
	private FacilitieUseDao facilitieUseDao;
	private FacilitieDao facilitieDao;
	@Resource
	public void setFacilitieDao(FacilitieDao facilitieDao) {
		this.facilitieDao = facilitieDao;
	}
	@Resource
	public void setFacilitieUseDao(FacilitieUseDao facilitieUseDao) {
		setBaseDao(facilitieUseDao);
		this.facilitieUseDao = facilitieUseDao;
	}
	@Override
	public void addAndEditFacilitie(FacilitieUse facilitieUse) {
		Facilitie facilitie = facilitieDao.findObjectById(facilitieUse.getFacilitieId().getId());
		Integer maxNum = facilitie.getNormalNum();
		if(facilitieUse.getUseNum() <= maxNum){
			facilitieUseDao.save(facilitieUse);
			facilitie.setNormalNum(facilitie.getNormalNum() - facilitieUse.getUseNum());
			facilitieDao.update(facilitie);
		}
	}
	@Override
	public void deleteAndEditFacilitie(FacilitieUse facilitieUse) {
		facilitieUse = facilitieUseDao.findObjectById(facilitieUse.getId());
		Facilitie facilitie = facilitieDao.findObjectById(facilitieUse.getFacilitieId().getId());
		facilitieUseDao.delete(facilitieUse.getId());
		facilitie.setNormalNum(facilitie.getNormalNum()+facilitieUse.getUseNum());
		facilitieDao.update(facilitie);
	}
	@Override
	public void editAndEditFacilitie(FacilitieUse facilitieUse) {
		if(facilitieUse.getFacilitieId()!=null){
			//保存新数量
			Integer newNum = facilitieUse.getUseNum();
			//获取原来数据
			facilitieUse = facilitieUseDao.findObjectById(facilitieUse.getId());
			//获取当前设施
			Facilitie facilitie = facilitieDao.findObjectById(facilitieUse.getFacilitieId().getId());
			//判断设施是否改变
			if(facilitie.getId().equals(facilitieUse.getFacilitieId().getId())){
				Integer oldNum = facilitieUse.getUseNum();
				facilitieUse.setUseNum(newNum);
				facilitie.setNormalNum(facilitie.getNormalNum()+(oldNum-newNum));
				if(facilitie.getNormalNum() > 0){
					facilitieDao.update(facilitie);
					facilitieUseDao.update(facilitieUse);
				}
			}else{
				deleteAndEditFacilitie(facilitieUse);
				addAndEditFacilitie(facilitieUse);
			}
		}
	}
}
