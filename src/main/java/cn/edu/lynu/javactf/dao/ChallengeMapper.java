package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.Challenge;
import cn.edu.lynu.javactf.model.ChallengeExtended;

@Mapper
public interface ChallengeMapper {
	
	@Select("SELECT challenge.*, category.name as category_name FROM challenge,category WHERE challenge.category_id=category.id")
	List<ChallengeExtended> getAllChallenges();
	
	@Select("SELECT challenge.*, category_id as categoryId FROM challenge WHERE ID=#{id}")
	Challenge getChallengeById(@Param("id") int id);
	
	@Delete("DELETE challenge WHERE ID = #{id}")
	int deleteChallengeById(@Param("id")int id);
	
	@Insert("INSERT INTO challenge(category_id ,name, content) VALUES (#{challenge.category.id}, #{challenge.name}, #{challenge.content} )")
	int insertChallenge(@Param("challenge")Challenge challenge);
	
	@Update("UPDATE challenge SET NAME=#{challenge.name}, CONTENT=#{challenge.content}, CATEGORY_ID=#{challenge.category.id} WHERE ID = #{challenge.id}")
	int updateChallenge(@Param("challenge")Challenge challenge);
}
