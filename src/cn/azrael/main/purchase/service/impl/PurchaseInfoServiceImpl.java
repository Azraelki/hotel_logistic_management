package cn.azrael.main.purchase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.purchase.dao.PurchaseInfoDao;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.service.PurchaseInfoService;
@Service("purchaseInfoService")
public class PurchaseInfoServiceImpl extends BaseServiceImpl<PurchaseInfo> implements PurchaseInfoService{
	private PurchaseInfoDao purchaseInfoDao;
	@Resource
	public void setPurchaseInfoDao(PurchaseInfoDao purchaseInfoDao) {
		setBaseDao(purchaseInfoDao);
		this.purchaseInfoDao = purchaseInfoDao;
	}
}
