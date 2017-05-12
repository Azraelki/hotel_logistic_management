package cn.azrael.main.purchase.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.ExcelUtil;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.dao.FacilitieDao;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.purchase.dao.PurchaseInfoDao;
import cn.azrael.main.purchase.dao.PurchaseOrderDao;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.entity.PurchaseOrder;
import cn.azrael.main.purchase.service.PurchaseOrderService;
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl extends BaseServiceImpl<PurchaseOrder> implements PurchaseOrderService{
	private PurchaseOrderDao purchaseOrderDao;
	private FacilitieDao facilitieDao;
	private PurchaseInfoDao purchaseInfoDao;
	@Resource
	public void setPurchaseInfoDao(PurchaseInfoDao purchaseInfoDao) {
		this.purchaseInfoDao = purchaseInfoDao;
	}
	@Resource
	public void setFacilitieDao(FacilitieDao facilitieDao) {
		this.facilitieDao = facilitieDao;
	}
	@Resource
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		setBaseDao(purchaseOrderDao);
		this.purchaseOrderDao = purchaseOrderDao;
	}
	@Override
	public void changeAndUpdate(PurchaseOrder purchaseOrder) {
		QueryHelper queryHelper = new QueryHelper(PurchaseInfo.class, "pi");
		purchaseOrder.setDealDate(new Date().getTime()/1000.0);
		purchaseOrderDao.update(purchaseOrder);
		purchaseOrder = purchaseOrderDao.findObjectById(purchaseOrder.getId());
		queryHelper.addCondition("pi.purchaseOrderId.id=?", purchaseOrder.getId());
		List<PurchaseInfo> purchaseInfos = purchaseInfoDao.findObjects(queryHelper);
		Facilitie facilitie;
		for (PurchaseInfo purchaseInfo : purchaseInfos) {
			facilitie = purchaseInfo.getFacilitieId();
			facilitie.setNormalNum(facilitie.getNormalNum()+purchaseInfo.getPurchaseNum());
			facilitieDao.update(facilitie);
		}
	}
	@Override
	public void deleteAndUpdate(PurchaseOrder purchaseOrder) {
		QueryHelper queryHelper = new QueryHelper(PurchaseInfo.class, "pi");
		purchaseOrder = purchaseOrderDao.findObjectById(purchaseOrder.getId());
		if(purchaseOrder.getStatus() == 1){
			queryHelper.addCondition("pi.purchaseOrderId.id=?", purchaseOrder.getId());
			List<PurchaseInfo> purchaseInfos = purchaseInfoDao.findObjects(queryHelper);
			Facilitie facilitie;
			for (PurchaseInfo purchaseInfo : purchaseInfos) {
				facilitie = purchaseInfo.getFacilitieId();
				facilitie.setNormalNum(facilitie.getNormalNum()-purchaseInfo.getPurchaseNum());
				facilitieDao.update(facilitie);
			}
		}
		purchaseOrderDao.delete(purchaseOrder.getId());
	}
	@Override
	public void exportExcel(PurchaseOrder purchaseOrder,
			ServletOutputStream outputStream) {
		ExcelUtil.exportPurchaseExcel(purchaseOrder,outputStream);
	}
}
