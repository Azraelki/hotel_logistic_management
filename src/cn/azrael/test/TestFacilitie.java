package cn.azrael.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;

public class TestFacilitie {
	private ApplicationContext ac;
	private FacilitieService fs;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		fs = (FacilitieService) ac.getBean("facilitieService");
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
}
