package cn.edu.lynu.javactf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
	private int id;
	private Category category;
	private int categoryId;
	private String name;
	private String content;
}
