package cn.edu.lynu.javactf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachFile {
	private int id;
	private Challenge challenge; // 对应的Challenge, 多对一
	private String fileName;
	private String fileLocation;
	private Date uploadTime;
}
