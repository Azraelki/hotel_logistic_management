package cn.azrael.test.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.azrael.test.dao.TestDao;
import cn.azrael.test.entity.TestUser;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao{

	@Override
	public void save(TestUser t) {
		getHibernateTemplate().save(t);
	}

}
