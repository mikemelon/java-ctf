package cn.edu.lynu.javactf.model;

import lombok.Data;

@Data
public class Hint {
	private int id;
	private Challenge challenge;
	private String title;
	private String content;
}
