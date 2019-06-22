package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Rule;

public interface RuleService {
	
	Rule getRuleById(int id);
	
	List<Rule> getAllRules();
	
	void deleteRuleById(int id);
	
	void save(Rule rule);
	
	void update(Rule rule);

}
