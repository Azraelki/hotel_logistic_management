package cn.azrael.main.facilitie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.log.DescripLog;
import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.dao.FacilitieDao;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
@Service("facilitieService")
public class FacilitieServiceImpl extends BaseServiceImpl<Facilitie> implements FacilitieService{
	private FacilitieDao facilitieDao;
	@Resource
	public void setFacilitieDao(FacilitieDao facilitieDao) {
		setBaseDao(facilitieDao);
		this.facilitieDao = facilitieDao;
	}
	@Override
	public List<Facilitie> findByType(int type) {
		QueryHelper queryHelper = new QueryHelper(Facilitie.class, "f");
		queryHelper.addCondition("f.type=?", type);
		return facilitieDao.findObjects(queryHelper);
	}
	@Override
	public List<Facilitie> findByName(String name) {
		QueryHelper queryHelper = new QueryHelper(Facilitie.class, "f");
		queryHelper.addCondition("f.name like ?", "%"+name+"%");
		return facilitieDao.findObjects(queryHelper);
	}
	@DescripLog(desc="登记损坏布草信息，并更新布草信息")
	@Override
	public void invalidAndUpdate(Facilitie facilitie) throws ServiceException{
		int badNum = 0;
		badNum = facilitie.getBadNum();
		facilitie = facilitieDao.findObjectById(facilitie.getId());
		facilitie.setBadNum((facilitie.getBadNum()+badNum));
		facilitie.setNormalNum(facilitie.getNormalNum()-badNum);
		facilitieDao.update(facilitie);
	}
	
}
