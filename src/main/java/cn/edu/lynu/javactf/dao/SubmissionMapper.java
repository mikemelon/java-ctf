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

import cn.edu.lynu.javactf.model.Submission;

@Mapper
public interface SubmissionMapper {
	
	@Select("SELECT submission.*, user.id as user_id, user.username as user_name, challenge.id as challenge_id, challenge.name as challenge_name, category.name as category_name FROM submission,user,challenge,category WHERE submission.user_id=user.id AND submission.challenge_id=challenge.id AND challenge.category_id=category.id")
	@Results({@Result(column ="user_id",property = "user.id"), 
		@Result(column ="user_name",property = "user.username"), 
		@Result(column ="challenge_id",property = "challenge.id"), 
		@Result(column ="challenge_name",property = "challenge.name"), 
		@Result(column ="category_name",property = "challenge.category.name")})
	List<Submission> getAllSubmissions();
	
	@Select("SELECT * FROM submission WHERE ID=#{id}")
	Submission getSubmissionById(@Param("id") int id);
	
	@Delete("DELETE submission WHERE ID = #{id}")
	int deleteSubmissionById(@Param("id")int id);
	
	@Insert("INSERT INTO submission(user_id,challenge_id, content,correct,submittime) VALUES ( #{submission.user.id},#{submission.challenge.id},#{submission.content},#{submission.correct},#{submission.submitTime})")
	int insertSubmission(@Param("submission")Submission submission);
	
	@Update("UPDATE submission SET USER_ID=#{submission.user.id},CHALLENGE_ID=#{submission.challenge.id},CONTENT=#{submission.content},CORRECT=#{submission.correct},SUBMITTIME=#{submission.submitTime} WHERE ID = #{submission.id}")
	int updateSubmission(@Param("submission")Submission submission);
}
