package cn.azrael.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.service.EmployeeService;

public class TestEmployee {
	private ApplicationContext ac;
	@Before
	public void build(){
		ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"});
	}
	@Test
	public void test1(){
		EmployeeDao ed = (EmployeeDao) ac.getBean("employeeDao");
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");
		es.findObjects();
	}
}
