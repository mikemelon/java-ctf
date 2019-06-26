package cn.edu.lynu.javactf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLog {
	private int id;
	private User user;
	private String ipaddress;
	private String description;
	private Date operationTime;
}
