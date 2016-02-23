package com.hkbu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkbu.dao.UserDao;
import com.hkbu.domain.User;
import com.hkbu.service.UserService;
import com.hkbu.exception.AppException;
import com.hkbu.util.MD5Utils;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Resource(name="userDao")
    private UserDao userDao;

	
	public User login(User user)
	{
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return userDao.getByUsernameAndPassword(user);
	}


	
	public User getById(Long id)
	{
		
		return userDao.get(id);
	}



	
	public void save(User saveUser)
	{
		userDao.save(saveUser);
		
	}



	
	public void updateUser(User updateUser)
	{
		try
		{
			userDao.update(updateUser);
		} catch (Exception e)
		{
			throw new AppException("更新用户信息失败");
		}
		
		
	}
    
    
}
