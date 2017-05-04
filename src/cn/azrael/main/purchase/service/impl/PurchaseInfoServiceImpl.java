package cn.azrael.main.purchase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.facilitie.dao.FacilitieDao;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.purchase.dao.PurchaseInfoDao;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.service.PurchaseInfoService;
@Service("purchaseInfoService")
public class PurchaseInfoServiceImpl extends BaseServiceImpl<PurchaseInfo> implements PurchaseInfoService{
	private PurchaseInfoDao purchaseInfoDao;
	private FacilitieDao facilitieDao;
	@Resource
	public void setFacilitieDao(FacilitieDao facilitieDao) {
		this.facilitieDao = facilitieDao;
	}
	@Resource
	public void setPurchaseInfoDao(PurchaseInfoDao purchaseInfoDao) {
		setBaseDao(purchaseInfoDao);
		this.purchaseInfoDao = purchaseInfoDao;
	}
	@Override
	public void editAndUpdateFacilitie(PurchaseInfo purchaseInfo) {
		//暂时保存新的传入信息
		PurchaseInfo tem = purchaseInfo;
		//获得新数值
		Integer newNum = purchaseInfo.getPurchaseNum();
		//得到新的设施信息
		Facilitie facilitie = facilitieDao.findObjectById(purchaseInfo.getFacilitieId().getId());
		//得到旧的purchaseInfo
		purchaseInfo = purchaseInfoDao.findObjectById(purchaseInfo.getId());
		//判断新的设施种类和旧的是否相同
		if(tem.getFacilitieId().getId().equals(purchaseInfo.getFacilitieId().getId())){
			//得到原来保存的数值
			Integer oldNum = purchaseInfo.getPurchaseNum();
			facilitie.setNormalNum(facilitie.getNormalNum()+(newNum-oldNum));
			facilitieDao.update(facilitie);
			purchaseInfo.setFacilitieId(facilitie);
			purchaseInfo.setPrice(tem.getPrice());
			purchaseInfo.setPurchaseNum(newNum);
			purchaseInfo.setTotal(tem.getTotal());
			purchaseInfoDao.update(purchaseInfo);
		}else{
			deleteAndUpdateFacilitie(purchaseInfo);
			purchaseInfo = tem;
			purchaseInfoDao.save(purchaseInfo);
			facilitie.setNormalNum(facilitie.getNormalNum()+newNum);
			facilitieDao.update(facilitie);
		}
	}
	@Override
	public void deleteAndUpdateFacilitie(PurchaseInfo purchaseInfo) {
		Facilitie facilitie = facilitieDao.findObjectById(purchaseInfo.getFacilitieId().getId());
		facilitie.setNormalNum(facilitie.getNormalNum()-purchaseInfo.getPurchaseNum());
		facilitieDao.update(facilitie);
		purchaseInfoDao.delete(purchaseInfo.getId());
	}
}
