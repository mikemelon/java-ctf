package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Submission;

public interface SubmissionService {
	
	Submission getSubmissionById(int id);
	
	List<Submission> getAllSubmissions();
	
	void deleteSubmissionById(int id);
	
	void save(Submission submission);
	
	void update(Submission submission);

}
