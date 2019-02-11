package com.store.model;

import java.io.Serializable;

public class StoreVO implements Serializable{

	private static final long serialVersionUID = 135282473038340170L;
	
	private Integer store_no;
	private String store_name;
	private String store_phone;
	private String store_address;
	private String store_other;
	private byte[] store_photo;	
	public Integer getStore_no() {
		return store_no;
	}
	public void setStore_no(Integer store_no) {
		this.store_no = store_no;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_phone() {
		return store_phone;
	}
	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}
	public String getStore_address() {
		return store_address;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	public String getStore_other() {
		return store_other;
	}
	public void setStore_other(String store_other) {
		this.store_other = store_other;
	}
	public byte[] getStore_photo() {
		return store_photo;
	}
	public void setStore_photo(byte[] store_photo) {
		this.store_photo = store_photo;
	}
	
	@Override
	public String toString() {
		return "store_no="+this.store_no+"store_name="+store_name+"store_phone="+store_phone+"store_address="+store_address+"store_other="+store_other;
	}

}
