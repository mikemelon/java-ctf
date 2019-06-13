package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.ChallengeMapper;
import cn.edu.lynu.javactf.model.Challenge;
import cn.edu.lynu.javactf.model.ChallengeExtended;
import cn.edu.lynu.javactf.service.ChallengeService;

@Transactional
@Service
public class ChallengeServiceImpl implements ChallengeService{
	
	private static Logger logger = LoggerFactory.getLogger(ChallengeServiceImpl.class);
	@Autowired
	private ChallengeMapper challengeDao;

	@Override
	public void save(Challenge challenge) {
		int n = challengeDao.insertChallenge(challenge);
		logger.info("{}个Challenge插入数据库",n);
	}
	
	@Override
	public void update(Challenge challenge) {
		logger.info("challenge>>>>>>>>>>>>>>>>>>  {}",challenge);
		int n = challengeDao.updateChallenge(challenge);
		logger.info("{}个Challenge更新",n);
	}

	@Override
	public Challenge getChallengeById(int id) {
		return challengeDao.getChallengeById(id);
	}

	@Override
	public void deleteChallengeById(int id) {
		int n =challengeDao.deleteChallengeById(id);
		logger.info("{}个Challenge被删除", n );
		
	}

	@Override
	public List<ChallengeExtended> getAllChallenges() {
		return challengeDao.getAllChallenges();
	}

}
