package cn.azrael.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.purchase.dao.PurchaseOrderDao;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.entity.PurchaseOrder;
import cn.azrael.main.purchase.service.PurchaseInfoService;
import cn.azrael.main.purchase.service.PurchaseOrderService;
import cn.azrael.main.user.service.EmployeeService;


public class TestPurchase {
	private ApplicationContext ac;
	private PurchaseOrderService pos;
	private PurchaseInfoService pis;
	private EmployeeService es;
	private FacilitieService fs;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		pos = (PurchaseOrderService) ac.getBean("purchaseOrderService");
		pis = (PurchaseInfoService) ac.getBean("purchaseInfoService");
		es = (EmployeeService) ac.getBean("employeeService");
		fs = (FacilitieService) ac.getBean("facilitieService");
	}
	@Test
	public void testPurchaseAndInfoSave() throws Exception {
		pos.delete(pos.findObjects().get(0).getId());
		PurchaseOrder po = new PurchaseOrder();
		PurchaseInfo pi = new PurchaseInfo();
		po.setEmployeeId(es.findObjects().get(1));
		po.setStatus(0);
		po.setDate(new Date().getTime()/1000.0);
		pos.save(po);
		for (int i = 0; i < 10; i++) {
			pi.setFacilitieId(fs.findObjects().get(i));
			pi.setPurchaseNum(100+i);
			pi.setPurchaseOrderId(po);
			pi.setPrice(i+1.0);
			pi.setTotal(pi.getPrice()*pi.getPurchaseNum());
			pis.save(pi);
		}
	}
	@Test
	public void testQuery()throws Exception{
		PurchaseOrderDao pd =  (PurchaseOrderDao) ac.getBean("purchaseOrderDao");
		PurchaseOrder purchaseOrder = pd.findObjects().get(0);
		System.out.println(purchaseOrder.getPurchaseInfos());
	}
}
