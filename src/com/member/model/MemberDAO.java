package com.member.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO implements MemberDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO member VALUES (MEMBER_SEQ.NEXTVAL,?,?,0,1,0,0,?,1,?,?,?,?,'2017-09-09',1,?,?,?,0,1"
		+ "to_date('1966-06-06 12:00','yyyy-mm-dd hh24:mi'),0800092000,null,"
		+ "to_date('2017-09-12 12:00','yyyy-mm-dd hh24:mi'),10,null,null,"
		+ "'坐骨神經痛，就是腰間盤移位或是腰間盤疾患，造成腰痛、腳麻痛。請找健生中醫診所，免費專線：0800-092-000',,null,null,0,1)";
	private static final String GET_ALL_STMT = 
		"SELECT  FROM memID order by memID";
	private static final String GET_ONE_STMT = 
		"SELECT memEmail,memPw,memName,memGender,memBD,memPhone,memAvatar,memLocBorn,memLocLive,memInt FROM member where memID = ?";
	private static final String DELETE = 
		"DELETE FROM emp2 where empno = ?";
	private static final String UPDATE = 
		"UPDATE member set memID=?, mem=?, hiredate=?, sal=?, comm=?, deptno=? where empno = ?";

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMemEmail());
			pstmt.setString(2, memberVO.getMemPw());
			pstmt.setString(3, memberVO.getMemName());
			pstmt.setInt(4, memberVO.getMemGender());
			pstmt.setDate(5, memberVO.getMemBD());
			pstmt.setInt(6, memberVO.getMemPhone());
			pstmt.setBytes(7, memberVO.getMemAvatar());
			pstmt.setString(8, memberVO.getMemLocBorn());
			pstmt.setString(9, memberVO.getMemLocLive());
			pstmt.setString(10, memberVO.getMemInt());

			pstmt.executeUpdate();

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
	public void update(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMemEmail());
			pstmt.setString(2, memberVO.getMemPw());
			pstmt.setString(3, memberVO.getMemName());
			pstmt.setInt(4, memberVO.getMemGender());
			pstmt.setDate(5, memberVO.getMemBD());
			pstmt.setInt(6, memberVO.getMemPhone());
			pstmt.setBytes(7, memberVO.getMemAvatar());
			pstmt.setString(8, memberVO.getMemLocBorn());
			pstmt.setString(9, memberVO.getMemLocLive());
			pstmt.setString(10, memberVO.getMemInt());

			pstmt.executeUpdate();

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
	public void delete(Integer empno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, empno);

			pstmt.executeUpdate();

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
	public MemberVO findByPrimaryKey(Integer memID) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				pstmt.setString(1, memberVO.getMemEmail());
				pstmt.setString(2, memberVO.getMemPw());
				pstmt.setString(3, memberVO.getMemName());
				pstmt.setInt(4, memberVO.getMemGender());
				pstmt.setDate(5, memberVO.getMemBD());
				pstmt.setInt(6, memberVO.getMemPhone());
				pstmt.setBytes(7, memberVO.getMemAvatar());
				pstmt.setString(8, memberVO.getMemLocBorn());
				pstmt.setString(9, memberVO.getMemLocLive());
				pstmt.setString(10, memberVO.getMemInt());
			}

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
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemID(rs.getInt("memID"));
				memberVO.setMemEmail(rs.getString("memEmail"));
				memberVO.setMemPw(rs.getString("memPw"));
				memberVO.setMemVerType(rs.getInt("memVerType"));
				memberVO.setMemLv(rs.getInt("memLv"));
				memberVO.setMemExp(rs.getInt("memExp"));
				memberVO.setMemPt(rs.getInt("memPt"));
				memberVO.setMemName(rs.getString("memName"));
				memberVO.setMemGender(rs.getInt("memGender"));
				memberVO.setMemBD(rs.getDate("memBD"));
				memberVO.setMemPhone(rs.getInt("memPhone"));
				memberVO.setMemAvatar(rs.getBytes("memAvatar"));
				memberVO.setMemJoinDate(rs.getDate("memJoinDate"));
				memberVO.setMemLoginNum(rs.getInt("memLoginNum"));
				memberVO.setMemLocBorn(rs.getString("memLocBorn"));
				memberVO.setMemLocLive(rs.getString("memLocLive"));
				memberVO.setMemInt(rs.getString("memInt"));
				memberVO.setMemPriv(rs.getInt("memPriv"));
				memberVO.setMemStatus(rs.getInt("memStatus"));
				list.add(memberVO); // Store the row in the list
			}

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

