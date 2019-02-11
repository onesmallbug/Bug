package com.orders.model;

import java.io.Serializable;

public class OrdersVO implements Serializable{
	private static final long serialVersionUID = 78756791292406099L;
	
	private Integer groups_no;
	private String member_account;
	private Integer store_no;
	private Integer menu_no;
	private Integer orders_paid;
	
	public Integer getGroups_no() {
		return groups_no;
	}
	public void setGroups_no(Integer groups_no) {
		this.groups_no = groups_no;
	}
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public Integer getStore_no() {
		return store_no;
	}
	public void setStore_no(Integer store_no) {
		this.store_no = store_no;
	}
	public Integer getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(Integer menu_no) {
		this.menu_no = menu_no;
	}
	public Integer getOrders_paid() {
		return orders_paid;
	}
	public void setOrders_paid(Integer orders_paid) {
		this.orders_paid = orders_paid;
	}
	
	
	@Override
	public String toString() {
		return "groups_no="+groups_no+"member_account="+member_account+"store_no="+store_no+"menu_no="+menu_no+"orders_paid="+orders_paid;
	}

}
