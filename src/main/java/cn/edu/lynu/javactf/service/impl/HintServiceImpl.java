package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.HintMapper;
import cn.edu.lynu.javactf.model.Hint;
import cn.edu.lynu.javactf.service.HintService;

@Transactional
@Service
public class HintServiceImpl implements HintService{
	
	private static Logger logger = LoggerFactory.getLogger(HintServiceImpl.class);
	@Autowired
	private HintMapper hintDao;

	@Override
	public void save(Hint hint) {
		int n = hintDao.insertHint(hint);
		logger.info("{}个hint插入数据库",n);
	}
	
	@Override
	public void update(Hint hint) {
		int n = hintDao.updateHint(hint);
		logger.info("{}个hint更新",n);
	}

	@Override
	public Hint getHintById(int id) {
		return hintDao.getHintById(id);
	}

	@Override
	public void deleteHintById(int id) {
		int n = hintDao.deleteHintById(id);
		logger.info("{}个hint被删除", n );
		
	}

	@Override
	public List<Hint> getAllHints() {
		return hintDao.getAllHints();
	}

}
