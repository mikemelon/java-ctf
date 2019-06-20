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
import cn.edu.lynu.javactf.model.Hint;

@Mapper
public interface HintMapper {
	
	@Select("SELECT hint.*, challenge.name as challenge_name FROM hint,challenge where hint.challenge_id=challenge.id")
	List<Hint> getAllHints();
	
	@Select("SELECT hint.*, challenge_id as challengeId FROM hint WHERE ID=#{id}")
	Hint getHintById(@Param("id") int id);
	
	@Delete("DELETE hint WHERE ID = #{id}")
	int deleteHintById(@Param("id")int id);
	
	@Insert("INSERT INTO hint(challenge_id ,title, content) VALUES (#{hint.challenge.id}, #{hint.title}, #{hint.content} )")
	int insertHint(@Param("hint")Hint hint);
	
	@Update("UPDATE hint SET title=#{hint.title}, CONTENT=#{hint.content}, CHALLENGE_ID=#{hint.challenge.id} WHERE ID = #{hint.id}")
	int updateHint(@Param("hint")Hint hint);
}
