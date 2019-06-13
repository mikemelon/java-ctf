package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.User;

public interface UserService {
	
	User getUserById(int id);
	
	List<User> getAllUsers();
	
	void deleteUserById(int id);
	
	boolean isUserValid(User user);
	
	void save(User user);
	
	void update(User user);

}
