package cn.azrael.main.core.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.azrael.main.core.dao.BaseDao;
import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.log.DescripLog;
import cn.azrael.main.core.page.PageResult;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.core.util.QueryHelper;

public class BaseServiceImpl<T> implements BaseService<T>{
	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	@DescripLog(desc="添加实体")
	@Override
	public void save(T entity) throws ServiceException{
		baseDao.save(entity);
	}
	@DescripLog(desc="更新实体")
	@Override
	public void update(T entity) throws ServiceException{
		baseDao.update(entity);
	}
	@DescripLog(desc="删除实体")
	@Override
	public void delete(Serializable id) throws ServiceException{
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	@Override
	public List<T> findObjects() {
		return baseDao.findObjects();
	}
	
	@Override
	public List<T> findObjects(QueryHelper queryHelper) {
		return baseDao.findObjects(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		return baseDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}
