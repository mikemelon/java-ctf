package cn.edu.lynu.javactf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hint {
	private int id;
	private Challenge challenge;
	private String title;
	private String content;
}
