package cn.azrael.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.test.entity.TestUser;
import cn.azrael.test.service.TestService;

public class TestMerge {
	private ApplicationContext ac;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
	}
	
	@Test
	public void testSpring(){
		TestService testService = (TestService) ac.getBean("testService");
		testService.say();
	}
	
	@Test
	public void testHibernate(){
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		session.save(new TestUser("azrael"));
		ts.commit();
		session.close();
	}
	@Test
	public void testServiceAndDao(){
		TestService testService = (TestService) ac.getBean("testService");
		testService.save(new TestUser("azrael"));
		
	}
}
