package com.menu.model;

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


public class MenuDAOImpl implements MenuDAO{
	
	private static DataSource ds;

	static {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/DBD_MVC");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "INSERT INTO MENU (STORE_NO, MENU_NO, MENU_NAME, MENU_PRICE) VALUES (?,MENU_SEQ.NEXTVAL, ?, ?)";
	private static final String GET_ALL = "SELECT * FROM MENU";
	private static final String GET_ONE = "SELECT * FROM MENU WHERE STORE_NO = ? AND MENU_NO = ?";
	private static final String DELETE = "DELETE FROM MENU WHERE STORE_NO = ? AND MENU_NO = ?";
	private static final String UPDATE = "UPDATE MENU SET NEMU_NAME = ?, MENU_PRICE=? WHERE STORE_NO = ? AND MENU_NO = ?";
	
	@Override
	public void insert(MenuVO menuVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, menuVO.getStore_no());
			pstmt.setString(2, menuVO.getMenu_name());
			pstmt.setInt(3, menuVO.getMenu_price());

			System.out.println("MenuDAOImpl新增 "+pstmt.executeUpdate()+" 筆菜單");

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
	public void update(MenuVO menuVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, menuVO.getMenu_name());
			pstmt.setInt(2, menuVO.getMenu_price());
			pstmt.setInt(3, menuVO.getStore_no());
			pstmt.setInt(4, menuVO.getMenu_no());

			System.out.println("MenuDAOImpl修改 "+pstmt.executeUpdate()+" 筆菜單");

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
	public void delete(MenuVO menuVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, menuVO.getStore_no());
			pstmt.setInt(2, menuVO.getMenu_no());

			System.out.println("MenuDAOImpl刪除 "+pstmt.executeUpdate()+" 筆菜單");

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
	public MenuVO findByPrimaryKey(String store_no, String menu_no) {
		MenuVO menuVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);

			pstmt.setString(1, store_no);
			pstmt.setString(2, menu_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				menuVO = new MenuVO();
				menuVO.setStore_no(rs.getInt("STORE_NO"));
				menuVO.setMenu_no(rs.getInt("NEMU_NO"));
				menuVO.setMenu_name(rs.getString("MENU_NAME"));
				menuVO.setMenu_price(rs.getInt("MENU_PRICE"));
			}
			System.out.println(menuVO);

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
		return menuVO;
	}
	@Override
	public List<MenuVO> getAll() {
		List<MenuVO> list = new ArrayList<MenuVO>();
		MenuVO menuVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				menuVO = new MenuVO();
				menuVO.setStore_no(rs.getInt("STORE_NO"));
				menuVO.setMenu_no(rs.getInt("MENU_NO"));
				menuVO.setMenu_name(rs.getString("MENU_NAME"));
				menuVO.setMenu_price(rs.getInt("MENU_PRICE"));
				list.add(menuVO); // Store the row in the list
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
