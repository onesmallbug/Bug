package com.groups.model;

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

public class GroupsDAOImpl implements GroupsDAO{
	
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
	
	private static final String INSERT = "INSERT INTO GROUPS VALUES (GROUPS_SEQ.NEXTVAL,?,?,?,?,?);";
	private static final String GET_ALL = "SELECT * FROM GROUPS";
	private static final String GET_ONE = "SELECT * FROM GROUPS WHERE GROUPS_NO = ?";
	private static final String DELETE = "DELETE FROM GROUPS WHERE GROUPS_NO = ?";
	private static final String UPDATE = "UPDATE GROUPS SET STORE_NO = ?, MEMBER_ACCOUNT=?, GROUPS_NAME=?, GROUPS_DATE=?, GROUPS_EXPIRE=? WHERE GROUPS_NO = ?";
	
	

	@Override
	public void insert(GroupsVO groupsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, groupsVO.getStore_no());
			pstmt.setString(2, groupsVO.getMember_account());
			pstmt.setString(3, groupsVO.getGroups_name());
			pstmt.setDate(4, new java.sql.Date(groupsVO.getGroups_date().getTime()/86400000*86400000));
			pstmt.setDate(5, new java.sql.Date(groupsVO.getGroups_expire().getTime()/86400000*86400000));

			System.out.println("GroupsDAOImpl新增 "+pstmt.executeUpdate()+" 筆揪團");

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
	public void update(GroupsVO groupsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, groupsVO.getStore_no());
			pstmt.setString(2, groupsVO.getMember_account());
			pstmt.setString(3, groupsVO.getGroups_name());
			pstmt.setDate(4, new java.sql.Date(groupsVO.getGroups_date().getTime()/86400000*86400000));
			pstmt.setDate(5, new java.sql.Date(groupsVO.getGroups_expire().getTime()/86400000*86400000));
			pstmt.setInt(6, groupsVO.getGroups_no());

			System.out.println("GroupsDAOImpl修改 "+pstmt.executeUpdate()+" 筆揪團");

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
	public void delete(GroupsVO groupsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, groupsVO.getGroups_no());

			System.out.println("GroupsDAOImpl刪除 "+pstmt.executeUpdate()+" 筆揪團");

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
	public GroupsVO findByPrimaryKey(Integer groups_no) {
		GroupsVO groupsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);

			pstmt.setInt(1, groups_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				groupsVO = new GroupsVO();
				groupsVO.setGroups_no(rs.getInt("GROUPS_NO"));
				groupsVO.setStore_no(rs.getInt("STORE_NO"));
				groupsVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				groupsVO.setGroups_name(rs.getString("GROUPS_NAME"));
				groupsVO.setGroups_date(rs.getDate("GROUPS_DATE"));
				groupsVO.setGroups_expire(rs.getDate("GROUPS_EXPIRE"));
				
			}
			System.out.println(groupsVO);

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
		return groupsVO;
	}

	@Override
	public List<GroupsVO> getAll() {
		List<GroupsVO> list = new ArrayList<GroupsVO>();
		GroupsVO groupsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				groupsVO = new GroupsVO();
				groupsVO.setGroups_no(rs.getInt("GROUPS_NO"));
				groupsVO.setStore_no(rs.getInt("STORE_NO"));
				groupsVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				groupsVO.setGroups_name(rs.getString("GROUPS_NAME"));
				groupsVO.setGroups_date(rs.getDate("GROUPS_DATE"));
				groupsVO.setGroups_expire(rs.getDate("GROUPS_EXPIRE"));		
				list.add(groupsVO); // Store the row in the list
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
