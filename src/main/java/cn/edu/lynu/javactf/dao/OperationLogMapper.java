package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.OperationLog;

@Mapper
public interface OperationLogMapper {
	
	@Select("SELECT operationlog.*,user.id as user_id, user.username as user_name FROM operationlog,user WHERE operationlog.user_id=user.id")
	@Results({@Result(column = "user_id",property = "user.id"),
			@Result(column = "user_name",property = "user.username")})
	List<OperationLog> getAllOperationLogs();
	
	@Select("SELECT * FROM operationlog WHERE ID=#{id}")
	OperationLog getOperationLogById(@Param("id") int id);
	
	@Delete("DELETE operationlog WHERE ID = #{id}")
	int deleteOperationLogById(@Param("id")int id);
	
	@Insert("INSERT INTO operationlog(user_id, ipaddress, description, operationtime) VALUES ( #{operationlog.user.id}, #{operationlog.ipaddress},#{operationlog.description}, #{operationlog.operationTime})")
	int insertOperationLog(@Param("operationlog")OperationLog operationlog);
	
	@Update("UPDATE operationlog SET USER_ID=#{operationlog.user.id},IPADDRESS=#{operationlog.ipaddress},DESCRIPTION=#{operationlog.description},OPERATIONTIME=#{operationlog.operationTime} WHERE ID = #{operationlog.id}")
	int updateOperationLog(@Param("operationlog")OperationLog operationlog);
}
