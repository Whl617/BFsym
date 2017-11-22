package com.longge.service;

import org.springframework.transaction.annotation.Transactional;
import com.longge.dao.UserDao;
import com.longge.domain.User;
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.queryById(user.getUsername())!=null)
		return false;
		else {
			userDao.add(user);
			return true;
		}
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean loginUser(User user) {
		User queryuser= userDao.queryById(user.getUsername());
		if(queryuser!=null)
		{   if(queryuser.getPassword().equals(user.getPassword()))return true;
		    else {
			return false;
		   }
		}
		else {
				return false;
		}
	}

}
