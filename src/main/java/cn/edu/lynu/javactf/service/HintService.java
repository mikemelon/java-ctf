package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Hint;

public interface HintService {
	
	Hint getHintById(int id);
	
	List<Hint> getAllHints();
	
	void deleteHintById(int id);
	
	void save(Hint hint);
	
	void update(Hint hint);

}
