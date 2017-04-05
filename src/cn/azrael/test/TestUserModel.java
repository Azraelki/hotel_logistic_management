package cn.azrael.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.EmployeeWorkDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.entity.User;

public class TestUserModel {
	private ApplicationContext ac;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
	}
	@Test
	public void testUser(){
		EmployeeDao ed = (EmployeeDao) ac.getBean("employeeDao");
		EmployeeWorkDao ewd = (EmployeeWorkDao) ac.getBean("employeeWorkDao");
		UserDao ud = (UserDao) ac.getBean("userDao");
		Employee e = new Employee();
		User u = new User();
		EmployeeWork ew = new EmployeeWork();
		e.setAge(22);
		e.setName("hello");
		e.setGender(false);
		e.setPhoneNumber("13456754346");
		e.setArrivedAt(new Date().getTime()/1000.0);
		//ed.save(e);
		u.setEmployeeId(ed.findObjectById("297e06de5b3d8f80015b3d8f82990000"));
		u.setType(1);
		u.setPassword("123456");
		ew.setEmployeeId(ed.findObjectById("297e06de5b3d8f80015b3d8f82990000"));
		ew.setLeaveNum(12);
		ew.setCleanNum(12);
		ew.setDate(new Date().getTime()/1000.0);
		ud.save(u);
		ewd.save(ew);
	}
}
