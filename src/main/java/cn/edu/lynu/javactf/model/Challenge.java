package cn.edu.lynu.javactf.model;

import lombok.Data;

@Data
public class Challenge {
	private int id;
	private Category category;
	private int categoryId;
	private String name;
	private String content;
}
