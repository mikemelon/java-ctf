package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.SubmissionMapper;
import cn.edu.lynu.javactf.model.Submission;
import cn.edu.lynu.javactf.service.SubmissionService;

@Transactional
@Service
public class SubmissionServiceImpl implements SubmissionService{
	
	private static Logger logger = LoggerFactory.getLogger(SubmissionServiceImpl.class);
	@Autowired
	private SubmissionMapper submissionDao;

	@Override
	public void save(Submission submission) {
		int n = submissionDao.insertSubmission(submission);
		logger.info("{}个submission插入数据库",n);
	}
	
	@Override
	public void update(Submission submission) {
		int n = submissionDao.updateSubmission(submission);
		logger.info("{}个submission更新",n);
	}

	@Override
	public Submission getSubmissionById(int id) {
		return submissionDao.getSubmissionById(id);
	}

	@Override
	public void deleteSubmissionById(int id) {
		int n = submissionDao.deleteSubmissionById(id);
		logger.info("{}个submission被删除", n );
		
	}

	@Override
	public List<Submission> getAllSubmissions() {
		return submissionDao.getAllSubmissions();
	}



}
