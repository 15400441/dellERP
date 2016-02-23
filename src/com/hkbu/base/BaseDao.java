package com.hkbu.base;

import java.util.List;

public interface BaseDao<T> {
	public void save(T t);
	
	public void update(T t);
	
	public void delete(T t);

	public List<T> getAll();
	
	public T get(Long uuid);
	
	public List<T> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount);

	public Integer getCount(BaseQueryModel qm);
}
