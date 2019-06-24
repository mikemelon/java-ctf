package cn.edu.lynu.javactf.model;

import java.util.Date;

import lombok.Data;

@Data
public class OperationLog {
	private int id;
	private User user;
	private String ipaddress;
	private String description;
	private Date operationTime;
}
