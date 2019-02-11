package com.member.model;

import java.util.List;

public interface MemberDAO {
	
	public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(MemberVO memberVO);
    public MemberVO findByPrimaryKey(String member_account);
    public List<MemberVO> getAll();

}
