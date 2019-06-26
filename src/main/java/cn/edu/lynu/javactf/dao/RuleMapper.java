package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.Rule;

@Mapper
public interface RuleMapper {
	
	@Select("SELECT * FROM rule")
	List<Rule> getAllRules();
	
	@Select("SELECT * FROM rule WHERE ID=#{id}")
	Rule getRuleById(@Param("id") int id);
	
	@Delete("DELETE rule WHERE ID = #{id}")
	int deleteRuleById(@Param("id")int id);
	
	@Insert("INSERT INTO rule(name, content) VALUES ( #{rule.name}, #{rule.content})")
	int insertRule(@Param("rule")Rule rule);
	
	@Update("UPDATE rule SET NAME=#{rule.name}, CONTENT=#{rule.content}  WHERE ID = #{rule.id}")
	int updateRule(@Param("rule")Rule rule);
}
