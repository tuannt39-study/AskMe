package vn.its.dao;

import vn.its.domain.Role;

public interface RoleDAO {
	
	Role findOne(String name);
	
}
