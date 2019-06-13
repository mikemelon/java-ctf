package cn.edu.lynu.javactf.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ChallengeExtended extends Challenge{
	private int category_id;
	private String category_name;
}
