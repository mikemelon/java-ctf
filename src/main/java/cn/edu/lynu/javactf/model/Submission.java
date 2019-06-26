package cn.edu.lynu.javactf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
	private int id;
	private User user;
	private Challenge challenge;
	String content;
	Boolean correct;
	Date submitTime;
}
