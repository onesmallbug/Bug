package com.groups.model;

import java.io.Serializable;
import java.sql.Date;

public class GroupsVO implements Serializable{
	private static final long serialVersionUID = -7575200632051607447L;
	
	private Integer groups_no;
	private Integer store_no;
	private String member_account;
	private String groups_name;
	private Date groups_date;
	private Date groups_expire;
	
	public Integer getGroups_no() {
		return groups_no;
	}
	public void setGroups_no(Integer groups_no) {
		this.groups_no = groups_no;
	}
	public Integer getStore_no() {
		return store_no;
	}
	public void setStore_no(Integer store_no) {
		this.store_no = store_no;
	}
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getGroups_name() {
		return groups_name;
	}
	public void setGroups_name(String groups_name) {
		this.groups_name = groups_name;
	}
	public Date getGroups_date() {
		return groups_date;
	}
	public void setGroups_date(Date groups_date) {
		this.groups_date = groups_date;
	}
	public Date getGroups_expire() {
		return groups_expire;
	}
	public void setGroups_expire(Date groups_expire) {
		this.groups_expire = groups_expire;
	}
	
	@Override
	public String toString() {
		return "groups_no="+this.groups_no+"store_no="+store_no+"member_account="+member_account+"groups_name="+groups_name+"groups_date="+groups_date+"groups_expire="+groups_expire;
	}

}
