package cn.edu.lynu.javactf.controller;

import java.util.List;
import java.util.Map;

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

import cn.edu.lynu.javactf.exception.HintNotFoundException;
import cn.edu.lynu.javactf.model.Challenge;
import cn.edu.lynu.javactf.model.Hint;
import cn.edu.lynu.javactf.service.ChallengeService;
import cn.edu.lynu.javactf.service.HintService;

@RestController
public class HintController {
	private static Logger logger = LoggerFactory.getLogger(HintController.class);
	@Autowired
	private HintService hintService;
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping(value = "/hints")
	public List<Hint> findAllHints() {
		return hintService.getAllHints();
	}
	
	@GetMapping(value = "/hint/{id}")
	public Hint getHintById(@PathVariable("id") Integer id) {
		return hintService.getHintById(id);
	}
	
	@PostMapping("/hint")
	@ResponseStatus(HttpStatus.CREATED)
	public void addHint(@RequestBody @Valid Hint hint) {
		hint.setChallenge(challengeService.getChallengeById(34));
		logger.info("add hint:{}", hint);
		hintService.save(hint);
	}
	
	@PutMapping("/hint")
	public void updateHint(@RequestBody Map<String, String> hint) {
		logger.info("update hint:{}", hint);
		
		Challenge challenge = new Challenge();
		challenge.setId( Integer.parseInt(hint.get("challenge_id")) );
		
		Hint realHint = new Hint();
		realHint.setId(Integer.parseInt(hint.get("id")) );
		realHint.setChallenge(challenge);
		realHint.setTitle(hint.get("title"));
		realHint.setContent(hint.get("content"));
		hintService.update(realHint);
	}
	
	@DeleteMapping(value = "/hint/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (hintService.getHintById(id) == null) {
			throw new HintNotFoundException();
		}
		logger.info("delete hint:id={}", id);
		hintService.deleteHintById(id);
	}
}
