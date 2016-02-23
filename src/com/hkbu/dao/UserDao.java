package com.hkbu.dao;

import com.hkbu.base.BaseDao;
import com.hkbu.domain.User;

public interface UserDao extends BaseDao<User>
{
   User getByUsernameAndPassword(User user);
}
