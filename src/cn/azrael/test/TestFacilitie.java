package cn.azrael.test;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.entity.FacilitieFix;
import cn.azrael.main.facilitie.service.FacilitieFixService;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.user.service.EmployeeService;

public class TestFacilitie {
	private ApplicationContext ac;
	private FacilitieService fs;
	private FacilitieFixService ffs;
	private EmployeeService es;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		fs = (FacilitieService) ac.getBean("facilitieService");
		ffs = (FacilitieFixService) ac.getBean("facilitieFixService");
		es = (EmployeeService) ac.getBean("employeeService");
	}
	
	@Test
	public void testFacilitieSave() throws Exception {
		Facilitie f = new Facilitie();
		for(int i = 1;i < 11;i++){
			f.setName("test"+i);
			f.setType(1);
			f.setNormalNum(100+i);
			f.setBadNum(i);
			fs.save(f);
		}
	}
	@Test
	public void testFacilitieFixSave() throws Exception {
		FacilitieFix ff = new FacilitieFix();
		ff.setDateBegin(new Date().getTime()/1000.0);
		for(int i = 0;i < 10;i++){
			ff.setEmployeeId(es.findObjects().get(i));
			ff.setStatus(1);
			ff.setContnet("马桶坏了");
			ff.setFacilitieId(fs.findObjects().get(i));
			ffs.save(ff);
		}
	}
}
