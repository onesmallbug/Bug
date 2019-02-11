package com.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StoreDAOImpl implements StoreDAO{
	
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
	
	private static final String INSERT = "INSERT INTO STORE VALUES (STORE_SEQ.NEXTVAL,?,?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM STORE";
	private static final String GET_ONE = "SELECT * FROM STORE WHERE STORE_NO = ?";
	private static final String DELETE = "DELETE FROM STORE WHERE STORE_NO = ?";
	private static final String UPDATE = "UPDATE STORE SET STORE_NAME = ?, STORE_PHONE=?, STORE_ADDRESS=?, STORE_OTHER=?, STORE_PHOTO=? WHERE STORE_NO = ?";
	
	@Override
	public void insert(StoreVO storeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, storeVO.getStore_name());
			pstmt.setString(2, storeVO.getStore_phone());
			pstmt.setString(3, storeVO.getStore_address());
			pstmt.setString(4, storeVO.getStore_other());
			pstmt.setBytes(5, storeVO.getStore_photo());

			System.out.println("StoreDAOImpl新增 "+pstmt.executeUpdate()+" 筆店家");

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
	public void update(StoreVO storeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, storeVO.getStore_name());
			pstmt.setString(2, storeVO.getStore_phone());
			pstmt.setString(3, storeVO.getStore_address());
			pstmt.setString(4, storeVO.getStore_other());
			pstmt.setBytes(5, storeVO.getStore_photo());
			pstmt.setInt(6, storeVO.getStore_no());

			System.out.println("StoreDAOImpl修改 "+pstmt.executeUpdate()+" 筆菜單");

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
	public void delete(StoreVO storeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, storeVO.getStore_no());

			System.out.println("StoreDAOImpl刪除 "+pstmt.executeUpdate()+" 筆店家");

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
	public StoreVO findByPrimaryKey(String store_no) {
		StoreVO storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);

			pstmt.setString(1, store_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				storeVO = new StoreVO();
				storeVO.setStore_no(rs.getInt("STORE_NO"));
				storeVO.setStore_name(rs.getString("STORE_NAME"));
				storeVO.setStore_phone(rs.getString("STORE_PHONE"));
				storeVO.setStore_address(rs.getString("STORE_ADDRESS"));
				storeVO.setStore_other(rs.getString("STORE_OTHER"));
				storeVO.setStore_photo(rs.getBytes("STORE_PHOTO"));				
				
			}
			System.out.println(storeVO);

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
		return storeVO;
	}

	@Override
	public List<StoreVO> getAll() {
		List<StoreVO> list = Collections.synchronizedList(new ArrayList<StoreVO>());
		
		StoreVO storeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setStore_no(rs.getInt("STORE_NO"));
				storeVO.setStore_name(rs.getString("STORE_NAME"));
				storeVO.setStore_phone(rs.getString("STORE_PHONE"));
				storeVO.setStore_address(rs.getString("STORE_ADDRESS"));
				storeVO.setStore_other(rs.getString("STORE_OTHER"));
				storeVO.setStore_photo(rs.getBytes("STORE_PHOTO"));		
				list.add(storeVO); // Store the row in the list
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
