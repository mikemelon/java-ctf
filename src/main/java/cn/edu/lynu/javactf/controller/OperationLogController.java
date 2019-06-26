package cn.edu.lynu.javactf.controller;

import java.util.Calendar;
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

import cn.edu.lynu.javactf.exception.OperationLogNotFoundException;
import cn.edu.lynu.javactf.model.OperationLog;
import cn.edu.lynu.javactf.service.OperationLogService;
import cn.edu.lynu.javactf.service.UserService;

@RestController
public class OperationLogController {
	private static Logger logger = LoggerFactory.getLogger(OperationLogController.class);
	@Autowired
	private OperationLogService operationLogService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/operationlogs")
	public List<OperationLog> findAllOperationLogs() {
		return operationLogService.getAllOperationLogs();
	}
	
	@GetMapping(value = "/operationlog/{id}")
	public OperationLog getOperationLogById(@PathVariable("id") Integer id) {
		return operationLogService.getOperationLogById(id);
	}
	
	@PostMapping("/operationlog")
	@ResponseStatus(HttpStatus.CREATED)
	public void addOperationLog(@RequestBody @Valid OperationLog operationlog) {
		operationlog.setUser(userService.getUserById(36));//just for test!
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 6-1, 24, 19, 24, 45);// 2010-6-24 19:24:45
	    operationlog.setOperationTime(cal.getTime());//just for test!
		logger.info("add operationlog:{}", operationlog);
		operationLogService.save(operationlog);
	}
	
	@PutMapping("/operationlog")
	public void updateOperationLog(@RequestBody @Valid OperationLog operationlog) {
		logger.info("update operationlog:{}", operationlog);
		operationLogService.update(operationlog);
	}
	
	@DeleteMapping(value = "/operationlog/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (operationLogService.getOperationLogById(id) == null) {
			throw new OperationLogNotFoundException();
		}
		logger.info("delete operationlog:id={}", id);
		operationLogService.deleteOperationLogById(id);
	}
}
