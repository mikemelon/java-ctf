package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Challenge;
import cn.edu.lynu.javactf.model.ChallengeExtended;

public interface ChallengeService {
	
	Challenge getChallengeById(int id);
	
	List<ChallengeExtended> getAllChallenges();
	
	void deleteChallengeById(int id);
	
	void save(Challenge challenge);
	
	void update(Challenge challenge);

}
