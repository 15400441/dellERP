package com.hkbu.dao;

import com.hkbu.domain.Emp;
import com.hkbu.base.BaseDao;

public interface EmpDao extends BaseDao<Emp>
{

	Emp findByUsernameAndPwd(String userName, String pwd);

}
