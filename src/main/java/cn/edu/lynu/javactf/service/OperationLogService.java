package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.OperationLog;

public interface OperationLogService {
	
	OperationLog getOperationLogById(int id);
	
	List<OperationLog> getAllOperationLogs();
	
	void deleteOperationLogById(int id);
	
	void save(OperationLog operationlog);
	
	void update(OperationLog operationlog);

}
