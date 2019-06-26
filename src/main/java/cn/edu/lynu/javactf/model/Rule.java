package cn.edu.lynu.javactf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
	private int id;
	private String name;
	private String content;
}
