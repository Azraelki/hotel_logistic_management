package cn.azrael.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.linen.dao.LinenDao;
import cn.azrael.main.linen.dao.LinensInfoDao;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinenService;
import cn.azrael.main.linen.service.LinensInfoService;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.service.EmployeeService;

public class TestLinen {
	private ApplicationContext ac;
	private LinenService ls;
	private LinensInfoService lis;
	private EmployeeService es;
	private FacilitieService fs;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		ls = (LinenService) ac.getBean("linenService");
		lis = (LinensInfoService) ac.getBean("linensInfoService");
		es = (EmployeeService) ac.getBean("employeeService");
		fs = (FacilitieService) ac.getBean("facilitieService");
	}
	
	@Test
	public void testLinenAndInfoSave() throws Exception {
		Linen l = new Linen();
		LinensInfo li = new LinensInfo();
		l.setEmployeeId(es.findObjectById("402868815ba2bfaf015ba2bfb33a0006"));
		l.setDate(new Date().getTime()/1000.0);
		ls.save(l);
		for (int i = 0; i < 10; i++) {
			li.setFacilitieId(fs.findObjectById("402880eb5bbcd047015bbcd049f50000"));
			li.setRecNum(20+i);
			li.setSenNum(30-i);
			li.setBackWashNum(i);
			li.setOweNum(i);
			li.setLinenId(l);
			lis.save(li);
		}
	}
	@Test
	public void testLinenQuery() throws Exception {
		Linen l = ls.findObjectById("402868815ba2bfaf015ba2bfb33a0006");
		System.out.println(l.getLinensInfos());
	}
	@Test
	public void testLinendelete() throws Exception {
		ls.delete("402880eb5bbcd5cc015bbcd5cedb0000");
	}
	@Test
	public void testLinensInfoQuery() throws Exception {
		lis.findObjectById("402880eb5bbcd6e6015bbcd6e95b0006").getFacilitieId().getName();
	}
}
