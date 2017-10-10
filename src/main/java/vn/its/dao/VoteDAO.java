package vn.its.dao;

import vn.its.domain.Vote;

public interface VoteDAO {

    Vote findOne(int aid, int uid);

    void create(Vote vote);

}
