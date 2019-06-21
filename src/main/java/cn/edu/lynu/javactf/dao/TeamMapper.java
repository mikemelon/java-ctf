package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.Team;

@Mapper
public interface TeamMapper {
	
	@Select("SELECT * FROM team")
	List<Team> getAllTeams();
	
	@Select("SELECT * FROM team WHERE ID=#{id}")
	Team getTeamById(@Param("id") int id);
	
	@Delete("DELETE team WHERE ID = #{id}")
	int deleteTeamById(@Param("id")int id);
	
	@Insert("INSERT INTO team(name,score) VALUES ( #{team.name}, #{team.score})")
	int insertTeam(@Param("team")Team team);
	
	@Update("UPDATE team SET NAME=#{team.name}, SCORE=#{team.score} WHERE ID = #{team.id}")
	int updateTeam(@Param("team")Team team);
}
