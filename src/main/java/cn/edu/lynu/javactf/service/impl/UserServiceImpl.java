package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.UserMapper;
import cn.edu.lynu.javactf.model.User;
import cn.edu.lynu.javactf.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userDao;

	@Override
	public boolean isUserValid(User user) {
		List<User> allUsers = userDao.getAllUsers();
		for(User u: allUsers) {
			if(user.getUsername().equals(u.getUsername()) && 
					user.getPassword().equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void save(User user) {
		int n = userDao.insertUser(user);
		logger.info("{}个User插入数据库",n);
	}
	
	@Override
	public void update(User user) {
		int n = userDao.updateUser(user);
		logger.info("{}个User更新",n);
	}
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public void deleteUserById(int id) {
		int n = userDao.deleteUserById(id);
		logger.info("{}个用户被删除", n );
		
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}



}
