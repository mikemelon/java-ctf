package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.AttachFileMapper;
import cn.edu.lynu.javactf.model.AttachFile;
import cn.edu.lynu.javactf.service.AttachFileService;

@Transactional
@Service
public class AttachFileServiceImpl implements AttachFileService{
	
	private static Logger logger = LoggerFactory.getLogger(AttachFileServiceImpl.class);
	@Autowired
	private AttachFileMapper attachFileDao;

	@Override
	public void save(AttachFile attachFile) {
		int n = attachFileDao.insertAttachFile(attachFile);
		logger.info("{}个attachfile插入数据库",n);
	}
	
	@Override
	public void update(AttachFile attachFile) {
		int n = attachFileDao.updateAttachFile(attachFile);
		logger.info("{}个attachfile更新",n);
	}

	@Override
	public AttachFile getAttachFileById(int id) {
		return attachFileDao.getAttachFileById(id);
	}

	@Override
	public void deleteAttachFileById(int id) {
		int n = attachFileDao.deleteAttachFileById(id);
		logger.info("{}个attachfile被删除", n );
		
	}

	@Override
	public List<AttachFile> getAllAttachFiles() {
		return attachFileDao.getAllAttachFiles();
	}



}
