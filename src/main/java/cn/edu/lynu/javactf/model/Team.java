package cn.edu.lynu.javactf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
	private int id;
	private String name;
	private int score;
}
