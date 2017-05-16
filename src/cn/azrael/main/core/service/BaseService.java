package cn.azrael.main.core.service;

import java.io.Serializable;
import java.util.List;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.page.PageResult;
import cn.azrael.main.core.util.QueryHelper;


public interface BaseService<T>{
	//新增
	public void save(T entity)throws ServiceException;
	//更新
	public void update(T entity) throws ServiceException;
	//根据id删除
	public void delete(Serializable id)throws ServiceException;
	//根据id查询
	public T findObjectById(Serializable id);
	//查找列表
	public List<T> findObjects();
	//条件查询实体列表--查询助手queryHelper
	public List<T> findObjects(QueryHelper queryHelper);
	//分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
