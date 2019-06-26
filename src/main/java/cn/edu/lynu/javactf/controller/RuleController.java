package cn.edu.lynu.javactf.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.lynu.javactf.exception.RuleNotFoundException;
import cn.edu.lynu.javactf.model.Rule;
import cn.edu.lynu.javactf.service.RuleService;

@RestController
public class RuleController {
	private static Logger logger = LoggerFactory.getLogger(RuleController.class);
	@Autowired
	private RuleService ruleService;
	
	@GetMapping(value = "/rules")
	public List<Rule> findAllRules() {
		return ruleService.getAllRules();
	}
	
	@GetMapping(value = "/rule/{id}")
	public Rule getRuleById(@PathVariable("id") Integer id) {
		return ruleService.getRuleById(id);
	}
	
	@PostMapping("/rule")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRule(@RequestBody @Valid Rule rule) {
		logger.info("add rule:{}", rule);
		ruleService.save(rule);
	}
	
	@PutMapping("/rule")
	public void updateRule(@RequestBody @Valid Rule rule) {
		logger.info("update rule:{}", rule);
		ruleService.update(rule);
	}
	
	@DeleteMapping(value = "/rule/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (ruleService.getRuleById(id) == null) {
			throw new RuleNotFoundException();
		}
		logger.info("delete rule :id={}", id);
		ruleService.deleteRuleById(id);
	}
}
