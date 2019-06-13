package cn.edu.lynu.javactf.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.lynu.javactf.exception.ChallengeNotFoundException;
import cn.edu.lynu.javactf.model.Category;
import cn.edu.lynu.javactf.model.Challenge;
import cn.edu.lynu.javactf.model.ChallengeExtended;
import cn.edu.lynu.javactf.service.ChallengeService;

@RestController
public class ChallengeController {
	private static Logger logger = LoggerFactory.getLogger(ChallengeController.class);
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping(value = "/challenges")
	public List<ChallengeExtended> findAllChallenges() {
		return challengeService.getAllChallenges();
	}
	
	@GetMapping(value = "/challenge/{id}")
	public Challenge getChallengeById(@PathVariable("id") Integer id) {
		return challengeService.getChallengeById(id);
	}
	
	@PostMapping("/challenge")
	public void addChallenge(@RequestBody Map<String, String> challenge) {
		logger.info("add challenge:{}", challenge);
		Challenge realChallenge = new Challenge();
		Category category = new Category();
		category.setId( Integer.parseInt(challenge.get("category_id")) );
		realChallenge.setCategory(category);
		realChallenge.setName(challenge.get("name"));
		realChallenge.setContent(challenge.get("content"));
		challengeService.save(realChallenge);
	}
	
	@PutMapping("/challenge")
	public void updateChallenge(@RequestBody Map<String, String> challenge) {
		logger.info("update challenge:{}", challenge);
		
		Category category = new Category();
		category.setId( Integer.parseInt(challenge.get("category_id")) );

		Challenge realChallenge = new Challenge();
		realChallenge.setId( Integer.parseInt(challenge.get("id")) );
		realChallenge.setCategory(category);
		realChallenge.setName(challenge.get("name"));
		realChallenge.setContent(challenge.get("content"));
		challengeService.update(realChallenge);
	}
	
	@DeleteMapping(value = "/challenge/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (challengeService.getChallengeById(id) == null) {
			throw new ChallengeNotFoundException();
		}
		logger.info("delete challenge:id={}" , id);
		challengeService.deleteChallengeById(id);
	}
}
