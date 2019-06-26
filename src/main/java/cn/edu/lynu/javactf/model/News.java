package cn.edu.lynu.javactf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
	private int id;
	private String title;
	private String content;
}
