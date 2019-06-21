package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.AttachFile;

public interface AttachFileService {
	
	AttachFile getAttachFileById(int id);
	
	List<AttachFile> getAllAttachFiles();
	
	void deleteAttachFileById(int id);
	
	void save(AttachFile attachFile);
	
	void update(AttachFile attachFile);

}
