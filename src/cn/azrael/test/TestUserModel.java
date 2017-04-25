package cn.azrael.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.dao.EmployeeDao;
import cn.azrael.main.user.dao.EmployeeWorkDao;
import cn.azrael.main.user.dao.JobDao;
import cn.azrael.main.user.dao.UserDao;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.EmployeeWork;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.EmployeeService;
import cn.azrael.main.user.service.EmployeeWorkService;
import cn.azrael.main.user.service.JobService;

public class TestUserModel {
	private ApplicationContext ac;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
	}
	@Test
	public void testFindObject(){
		String s = "1234";
		QueryHelper queryHelper = new QueryHelper(Employee.class, "e");
		queryHelper.addCondition("e.name = ?", s);
		System.out.println(queryHelper.getQueryListHql());
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");
		List<Employee> el = es.findObjects(queryHelper);
		System.out.println(el.size());
		//System.out.println(es.findByName("1234"));
	}
	@Test
	public void testDataImport() throws ParseException{
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");
		EmployeeWorkService ews = (EmployeeWorkService) ac.getBean("employeeWorkService");
		Employee e = new Employee();
		Job j = new Job();
		j.setId(3);
		EmployeeWork ew = new EmployeeWork();
		e.setAge(10);
		e.setArrivedAt(new Date().getTime()/1000.0);
		e.setGender(false);
		e.setJobId(j);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0;i < 20;i++){
			e.setPhoneNumber("134234323" + i);
			e.setName("test"+i);
			es.save(e);
			e = es.findObjectById("402868815ba2bfaf015ba2bfb33a0006");
			ew.setEmployeeId(e);
			ew.setCleanNum(i+2);
			ew.setLeaveNum(30-i);
			ew.setDate(sdf.parse("2017-04-"+(i+1)).getTime()/1000.0);
			ews.save(ew);
		}
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
