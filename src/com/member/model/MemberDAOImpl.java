package com.member.model;

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

public class MemberDAOImpl implements MemberDAO {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBD_MVC");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT = "INSERT INTO MEMBER (MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME) VALUES (?, ?, ?)";
	private static final String GET_ALL = "SELECT * FROM MEMBER";
	private static final String GET_ONE = "SELECT * FROM MEMBER WHERE MEMBER_ACCOUNT = ?";
	private static final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ACCOUNT = ?";
	private static final String UPDATE = "UPDATE MEMBER SET MEMBER_PASSWORD=?, MEMBER_NAME=? WHERE MEMBER_ACCOUNT = ?";

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			// INSERT INTO MEMBER (MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME) VALUES (?,
			// ?, ?)

			pstmt.setString(1, memberVO.getMember_account());
			pstmt.setString(2, memberVO.getMember_password());
			pstmt.setString(3, memberVO.getMember_name());

			System.out.println("MemberDAOImpl新增 "+pstmt.executeUpdate()+" 筆會員");

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			// UPDATE MEMBER SET MEMBER_PASSWORD=?, MEMBER_NAME=? WHERE MEMBER_ACCOUNT = ?

			pstmt.setString(1, memberVO.getMember_account());
			pstmt.setString(2, memberVO.getMember_password());
			pstmt.setString(3, memberVO.getMember_name());

			System.out.println("MemberDAOImpl修改 "+pstmt.executeUpdate()+" 筆會員");

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			// DELETE FROM MEMBER WHERE MEMBER_ACCOUNT = ?

			pstmt.setString(1, memberVO.getMember_account());

			System.out.println("MemberDAOImpl刪除 "+pstmt.executeUpdate()+" 筆會員");

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public MemberVO findByPrimaryKey(String member_account) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			// SELECT * FROM MEMBER WHERE MEMBER_ACCOUNT = ?

			pstmt.setString(1, member_account);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				// MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME
				memberVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				memberVO.setMember_password(rs.getString("MEMBER_PASSWORD"));
				memberVO.setMember_name(rs.getString("MEMBER_NAME"));

			}
			System.out.println(memberVO);
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		//SELECT * FROM MEMBER
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				// MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME
				memberVO.setMember_account(rs.getString("MEMBER_ACCOUNT"));
				memberVO.setMember_password(rs.getString("MEMBER_PASSWORD"));
				memberVO.setMember_name(rs.getString("MEMBER_NAME"));
				list.add(memberVO); // Store the row in the list
			}
			System.out.println(list);
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
