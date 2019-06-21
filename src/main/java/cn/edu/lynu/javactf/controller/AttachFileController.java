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

import cn.edu.lynu.javactf.exception.AttachFileNotFoundException;
import cn.edu.lynu.javactf.model.AttachFile;
import cn.edu.lynu.javactf.service.AttachFileService;
import cn.edu.lynu.javactf.service.ChallengeService;

@RestController
public class AttachFileController {
	private static Logger logger = LoggerFactory.getLogger(AttachFileController.class);
	@Autowired
	private AttachFileService attachFileService;
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping(value = "/attachfiles")
	public List<AttachFile> findAllAttachFiles() {
		return attachFileService.getAllAttachFiles();
	}
	
	@GetMapping(value = "/attachfile/{id}")
	public AttachFile getAttachFileById(@PathVariable("id") Integer id) {
		return attachFileService.getAttachFileById(id);
	}
	
	@PostMapping("/attachfile")
	public void addAttachFile(@RequestBody @Valid AttachFile attachFile) {
		attachFile.setChallenge(challengeService.getChallengeById(65));//just for test!
		attachFile.setUploadTime(new Date());
		logger.info("add attachfile:{}", attachFile);
		attachFileService.save(attachFile);
	}
	
	@PutMapping("/attachfile")
	public void updateAttachFile(@RequestBody @Valid AttachFile attachFile) {
		logger.info("update attachfile:{}", attachFile);
		attachFileService.update(attachFile);	
	}
	
	@DeleteMapping(value = "/attachfile/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (attachFileService.getAttachFileById(id) == null) {
			throw new AttachFileNotFoundException();
		}
		logger.info("delete attachfile:id={}", id);
		attachFileService.deleteAttachFileById(id);
	}
}
