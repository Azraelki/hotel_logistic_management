package cn.azrael.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.EmployeeWorkDao;
import cn.azrael.main.user.dao.JobDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.JobService;

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
		JobDao jd = (JobDao) ac.getBean("jobDao");
		Job j = new Job();
		Employee e = new Employee();
		User u = new User();
		EmployeeWork ew = new EmployeeWork();
		j.setId(2);
		j.setName("经理");
		//jd.save(j);
		e.setJobId(j);
		e.setAge(22);
		e.setName("hello");
		e.setGender(false);
		e.setPhoneNumber("13456754346");
		e.setArrivedAt(new Date().getTime()/1000.0);
		//ed.save(e);
		u.setEmployeeId(ed.findObjectById("402880eb5b415ed9015b415edab50000"));
		u.setType(1);
		u.setPassword("123456");
		ew.setEmployeeId(ed.findObjectById("402880eb5b415ed9015b415edab50000"));
		ew.setLeaveNum(12);
		ew.setCleanNum(12);
		ew.setDate(new Date().getTime()/1000.0);
		ud.save(u);
		ewd.save(ew);
	}
	@Test
	public void testJob(){
		JobService js = (JobService) ac.getBean("jobService");
		js.findObjects();
	}
}
