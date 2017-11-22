package com.longge.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.longge.domain.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		this.getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryById(String username) {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().get(User.class, username);
		
	}

}
