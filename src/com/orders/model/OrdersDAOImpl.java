package com.orders.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdersDAOImpl implements OrdersDAO{
	
	
	private static DataSource ds;
	
	static {
		Context ctx;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBD_MVC");
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}
	
	private static final String INSERT = "INSERT INTO ORDERS VALUES (?,?,?,?,?);";
	private static final String GET_ALL = "SELECT * FROM ORDERS";
	private static final String GET_ONE = "SELECT * FROM ORDERS WHERE GROUPS_NO = ? AND MEMBER_NO = ?";
	private static final String DELETE = "DELETE FROM ORDERS WHERE GROUPS_NO = ? AND MEMBER_NO = ?";
	private static final String UPDATE = "UPDATE ORDERS SET STORE_NO = ?, MENU_NO=?, ORDERS_PAID=? WHERE GROUPS_NO = ? AND MEMBER_NO = ?";
	
	

	@Override
	public void insert(OrdersVO ordersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, ordersVO.getGroups_no());
			pstmt.setString(2, ordersVO.getMember_account());
			pstmt.setInt(3, ordersVO.getStore_no());
			pstmt.setInt(4, ordersVO.getMenu_no());
			pstmt.setInt(5, ordersVO.getOrders_paid());

			System.out.println("OrdersDAOImpl新增 "+pstmt.executeUpdate()+" 筆訂單");

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(OrdersVO ordersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ordersVO.getStore_no());
			pstmt.setInt(2, ordersVO.getMenu_no());
			pstmt.setInt(3, ordersVO.getOrders_paid());
			pstmt.setInt(4, ordersVO.getGroups_no());
			pstmt.setString(5, ordersVO.getMember_account());

			System.out.println("OrdersDAOImpl修改 "+pstmt.executeUpdate()+" 筆訂單");

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(OrdersVO ordersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, ordersVO.getGroups_no());
			pstmt.setString(2, ordersVO.getMember_account());

			System.out.println("OrdersDAOImpl刪除 "+pstmt.executeUpdate()+" 筆訂單");

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public OrdersVO findByPrimaryKey(Integer groups_no, String member_no) {
		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);

			pstmt.setInt(1, groups_no);
			pstmt.setString(2, member_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				ordersVO = new OrdersVO();
				ordersVO.setGroups_no(rs.getInt("GROUPS_NO"));
				ordersVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				ordersVO.setStore_no(rs.getInt("STORE_NO"));
				ordersVO.setMenu_no(rs.getInt("MENU_NO"));
				ordersVO.setOrders_paid(rs.getInt("ORDERS_PAID"));
				
			}
			System.out.println(ordersVO);

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return ordersVO;
	}

	@Override
	public List<OrdersVO> getAll() {
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setGroups_no(rs.getInt("GROUPS_NO"));
				ordersVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				ordersVO.setStore_no(rs.getInt("STORE_NO"));
				ordersVO.setMenu_no(rs.getInt("MENU_NO"));
				ordersVO.setOrders_paid(rs.getInt("ORDERS_PAID"));		
				list.add(ordersVO); // Store the row in the list
			}
			System.out.println(list);
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}
