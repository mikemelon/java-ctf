package cn.edu.lynu.javactf.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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

import cn.edu.lynu.javactf.exception.SubmissionNotFoundException;
import cn.edu.lynu.javactf.model.Submission;
import cn.edu.lynu.javactf.service.ChallengeService;
import cn.edu.lynu.javactf.service.SubmissionService;
import cn.edu.lynu.javactf.service.UserService;

@RestController
public class SubmissionController {
	private static Logger logger = LoggerFactory.getLogger(SubmissionController.class);
	@Autowired
	private SubmissionService submissionService;
	@Autowired
	private UserService userService;
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping(value = "/submissions")
	public List<Submission> findAllSubmissions() {
		return submissionService.getAllSubmissions();
	}
	
	@GetMapping(value = "/submission/{id}")
	public Submission getSubmissionById(@PathVariable("id") Integer id) {
		return submissionService.getSubmissionById(id);
	}
	
	@PostMapping("/submission")
	public void addSubmission(@RequestBody @Valid Submission submission) {
		submission.setUser(userService.getUserById(36));//test only
		submission.setChallenge(challengeService.getChallengeById(66));//test only
		submission.setSubmitTime(new Date());
		logger.info("add submission:{}", submission);
		submissionService.save(submission);
	}
	
	@PutMapping("/submission")
	public void updateSubmission(@RequestBody @Valid Submission submission) {
		logger.info("update submission:{}", submission);
		submissionService.update(submission);
	}
	
	@DeleteMapping(value = "/submission/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (submissionService.getSubmissionById(id) == null) {
			throw new SubmissionNotFoundException();
		}
		logger.info("delete submission:id={}", id);
		submissionService.deleteSubmissionById(id);
	}
}
