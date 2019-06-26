package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.RuleMapper;
import cn.edu.lynu.javactf.model.Rule;
import cn.edu.lynu.javactf.service.RuleService;

@Transactional
@Service
public class RuleServiceImpl implements RuleService{
	
	private static Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);
	@Autowired
	private RuleMapper ruleDao;

	@Override
	public void save(Rule rule) {
		int n = ruleDao.insertRule(rule);
		logger.info("{}个rule插入数据库",n);
	}
	
	@Override
	public void update(Rule rule) {
		int n = ruleDao.updateRule(rule);
		logger.info("{}个rule更新",n);
	}

	@Override
	public Rule getRuleById(int id) {
		return ruleDao.getRuleById(id);
	}

	@Override
	public void deleteRuleById(int id) {
		int n = ruleDao.deleteRuleById(id);
		logger.info("{}个rule被删除", n );
		
	}

	@Override
	public List<Rule> getAllRules() {
		return ruleDao.getAllRules();
	}

}
