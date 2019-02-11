package com.groups.model;

import java.util.List;

public interface GroupsDAO {
	public void insert(GroupsVO groupsVO);
    public void update(GroupsVO groupsVO);
    public void delete(GroupsVO groupsVO);
    public GroupsVO findByPrimaryKey(Integer groups_no);
    public List<GroupsVO> getAll();
}
