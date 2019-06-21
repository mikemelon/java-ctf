package cn.edu.lynu.javactf.model;

import java.util.Date;

import lombok.Data;

@Data
public class AttachFile {
	private int id;
	private Challenge challenge; // 对应的Challenge, 多对一
	private String fileName;
	private String fileLocation;
	private Date uploadTime;
}
