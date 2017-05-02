package cn.azrael.main.purchase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.purchase.dao.PurchaseOrderDao;
import cn.azrael.main.purchase.entity.PurchaseOrder;
import cn.azrael.main.purchase.service.PurchaseOrderService;
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl extends BaseServiceImpl<PurchaseOrder> implements PurchaseOrderService{
	private PurchaseOrderDao purchaseOrderDao;
	@Resource
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		setBaseDao(purchaseOrderDao);
		this.purchaseOrderDao = purchaseOrderDao;
	}
}
