package com.menu.model;

import java.io.Serializable;

public class MenuVO implements Serializable{
	private static final long serialVersionUID = -2676420803466626475L;

	private Integer store_no;
	private Integer menu_no;
	private String menu_name;
	private Integer menu_price;
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
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public Integer getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(Integer manu_price) {
		this.menu_price = manu_price;
	}
	
	@Override
	public String toString() {		
		return "store_no="+this.getStore_no()+"menu_no="+this.getMenu_no()+"menu_name="+this.getMenu_name()+"manu_price="+this.getMenu_price();
	}

}
