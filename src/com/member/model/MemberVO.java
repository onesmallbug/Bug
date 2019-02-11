package com.member.model;

import java.io.Serializable;

public class MemberVO implements Serializable{
	
	private static final long serialVersionUID = -5315079099000747976L;
	
	private String member_account;
	private String member_password;
	private String member_name;
	
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	@Override
	public String toString() {
		return "member_account="+this.member_account+"member_password="+this.member_password+"member_name="+this.member_name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member_account == null) ? 0 : member_account.hashCode());
		result = prime * result + ((member_name == null) ? 0 : member_name.hashCode());
		result = prime * result + ((member_password == null) ? 0 : member_password.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (member_account == null) {
			if (other.member_account != null)
				return false;
		} else if (!member_account.equals(other.member_account))
			return false;
		if (member_password == null) {
			if (other.member_password != null)
				return false;
		} else if (!member_password.equals(other.member_password))
			return false;
		return true;
	}
	
}
