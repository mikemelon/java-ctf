package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM user")
	List<User> getAllUsers();
	
	@Select("SELECT * FROM user WHERE ID=#{id}")
	User getUserById(@Param("id") int id);
	
	@Delete("DELETE user WHERE ID = #{id}")
	int deleteUserById(@Param("id")int id);
	
	@Insert("INSERT INTO user(username, password) VALUES ( #{user.username}, #{user.password} )")
	int insertUser(@Param("user")User user);
	
	@Update("UPDATE user SET USERNAME=#{user.username}, PASSWORD=#{user.password} WHERE ID = #{user.id}")
	int updateUser(@Param("user")User user);
}
