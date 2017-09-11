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
			"INSERT INTO member VALUES (0,'adm@gmail','Master',2,50,42689,87870000,'Master',1,to_date('1988-08-08 12:00','yyyy-mm-dd hh24:mi'),0800666666,null,to_date('2017-08-15 13:00','yyyy-mm-dd hh24:mi'),239,null,'鏈婏拷@','闁夛拷濂嚧锟絋銊涙绀╄矈鑵旀┚锟姐剾锟叫筹拷鐪炽兌鐝傝墭鎵傝厰锟戒紟鐤戜簺',null,null,2,1);";
	private static final String GET_ALL_STMT = 
		"SELECT memID,memEmail,memPw,memberType,memLv,memExp,memPt,memName,memGender,memBD,memPhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,memLong,memLat,memPriv,memStatus FROM member order by memID";
	private static final String GET_ONE_STMT = 
		"SELECT memID,memEmail,memPw,memberType,memLv,memExp,memPt,memName,memGender,memBD,memPhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,memLong,memLat,memPriv,memStatus FROM member where memID = ?";
	private static final String DELETE = 
		"DELETE FROM member where memID = ?";
	private static final String UPDATE = 
		"UPDATE member set memID= ?,memEmail= ?,memPw= ?,memberType= ?,memLv= ?,memExp= ?,memPt= ?,memName= ?,memGender= ?,memBD= ?,memPhone= ?,memAvatar= ?,memJoinDate= ?,memLoginNum= ?,memLocBorn= ?,memLocLive= ?,memInt= ?,memLong= ?,memLat= ?,memPriv= ?,memStatus= ?";
	//登入用
	private static final String GET_ONE_STMT_BY_MEMEMAIL = 
			"SELECT memID,memEmail,memPw,memberType,memLv,memExp,memPt,memName,memGender,memBD,memPhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,memLong,memLat,memPriv,memStatus FROM member where memEmail = ?";
	private static final String GET_ONE_STMT_BY_MEMPW = 
			"SELECT memID,memEmail,memPw,memberType,memLv,memExp,memPt,memName,memGender,memBD,memPhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,memLong,memLat,memPriv,memStatus FROM member where memPw = ?";

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
				memberVO.setMemberType(rs.getInt("memberType"));
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
				memberVO.setMemLong(rs.getDouble("memLong"));
				memberVO.setMemLat(rs.getDouble("memLat"));
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

	@Override
	public MemberVO findByMemEmail(String memEmail) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT_BY_MEMEMAIL);

			pstmt.setString(1, memEmail);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemID(rs.getInt("memID"));
				memberVO.setMemEmail(rs.getString("memEmail"));
				memberVO.setMemPw(rs.getString("memPw"));
				memberVO.setMemberType(rs.getInt("memberType"));
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
				memberVO.setMemLong(rs.getDouble("memLong"));
				memberVO.setMemLat(rs.getDouble("memLat"));
				memberVO.setMemPriv(rs.getInt("memPriv"));
				memberVO.setMemStatus(rs.getInt("memStatus"));
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
	public MemberVO findByMemPw(String memPw) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT_BY_MEMPW);

			pstmt.setString(1, memPw);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemID(rs.getInt("memID"));
				memberVO.setMemEmail(rs.getString("memEmail"));
				memberVO.setMemPw(rs.getString("memPw"));
				memberVO.setMemberType(rs.getInt("memberType"));
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
				memberVO.setMemLong(rs.getDouble("memLong"));
				memberVO.setMemLat(rs.getDouble("memLat"));
				memberVO.setMemPriv(rs.getInt("memPriv"));
				memberVO.setMemStatus(rs.getInt("memStatus"));
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
}

