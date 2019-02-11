package com.store.model;

import java.util.List;

public interface StoreDAO {
	public void insert(StoreVO storeVO);
    public void update(StoreVO storeVO);
    public void delete(StoreVO storeVO);
    public StoreVO findByPrimaryKey(String store_no);
    public List<StoreVO> getAll();
}
