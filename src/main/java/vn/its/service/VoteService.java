package vn.its.service;

import vn.its.domain.Vote;

public interface VoteService {

	Vote findOne(int aid, int uid);

	void create(Vote vote);
	
}
