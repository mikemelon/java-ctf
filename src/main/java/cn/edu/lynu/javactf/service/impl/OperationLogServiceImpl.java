package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.OperationLogMapper;
import cn.edu.lynu.javactf.model.OperationLog;
import cn.edu.lynu.javactf.service.OperationLogService;

@Transactional
@Service
public class OperationLogServiceImpl implements OperationLogService{
	
	private static Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);
	@Autowired
	private OperationLogMapper operationLogDao;

	@Override
	public void save(OperationLog operationLog) {
		int n = operationLogDao.insertOperationLog(operationLog);
		logger.info("{}个operationLog插入数据库",n);
	}
	
	@Override
	public void update(OperationLog operationLog) {
		int n = operationLogDao.updateOperationLog(operationLog);
		logger.info("{}个operationLog更新",n);
	}

	@Override
	public OperationLog getOperationLogById(int id) {
		return operationLogDao.getOperationLogById(id);
	}

	@Override
	public void deleteOperationLogById(int id) {
		int n = operationLogDao.deleteOperationLogById(id);
		logger.info("{}个operationLog被删除", n );
		
	}

	@Override
	public List<OperationLog> getAllOperationLogs() {
		return operationLogDao.getAllOperationLogs();
	}



}
