package com.orders.model;

import java.util.List;

public interface OrdersDAO {
	public void insert(OrdersVO ordersVO);
    public void update(OrdersVO ordersVO);
    public void delete(OrdersVO ordersVO);
    public OrdersVO findByPrimaryKey(Integer groups_no,String member_no);
    public List<OrdersVO> getAll();
}
