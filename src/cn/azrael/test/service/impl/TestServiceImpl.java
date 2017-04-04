package cn.azrael.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.azrael.test.dao.TestDao;
import cn.azrael.test.entity.TestUser;
import cn.azrael.test.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	@Override
	public void say() {
		System.out.println("service say hello!");
	}

	@Override
	public void save(TestUser t) {
		testDao.save(t);
//		int i = 1 / 0;
	}

}
