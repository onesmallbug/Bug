package com.menu.model;

import java.util.List;

public interface MenuDAO{
	public void insert(MenuVO menuVO);
    public void update(MenuVO menuVO);
    public void delete(MenuVO menuVO);
    public MenuVO findByPrimaryKey(String store_no, String menu_no);
    public List<MenuVO> getAll();
}
