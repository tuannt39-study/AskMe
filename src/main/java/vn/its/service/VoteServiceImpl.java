package vn.its.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.its.dao.VoteDAO;
import vn.its.domain.Vote;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDAO voteDAO;
	
	@Override
	public Vote findOne(int aid, int uid) {
		return voteDAO.findOne(aid, uid);
	}

	@Override
	public void create(Vote vote) {
		voteDAO.create(vote);
	}

}
