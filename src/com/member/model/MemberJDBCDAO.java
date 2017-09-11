package com.member.model;

import java.util.*;
import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "demo11";
	String passwd = "say531328";

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

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memberVO.getMemID());
			pstmt.setString(2, memberVO.getMemEmail());
			pstmt.setString(3, memberVO.getMemPw());
			pstmt.setInt(4, memberVO.getMemberType());
			pstmt.setInt(5, memberVO.getMemLv());
			pstmt.setInt(6, memberVO.getMemExp());
			pstmt.setInt(7, memberVO.getMemPt());
			pstmt.setString(8, memberVO.getMemName());
			pstmt.setInt(9, memberVO.getMemGender());
			pstmt.setDate(10, memberVO.getMemBD());
			pstmt.setInt(11, memberVO.getMemPhone());
			pstmt.setBytes(12, memberVO.getMemAvatar());
			pstmt.setDate(13, memberVO.getMemJoinDate());
			pstmt.setInt(14, memberVO.getMemLoginNum());
			pstmt.setString(15, memberVO.getMemLocBorn());
			pstmt.setString(16, memberVO.getMemLocLive());
			pstmt.setString(17, memberVO.getMemInt());
			pstmt.setDouble(18, memberVO.getMemLong());	
			pstmt.setDouble(19, memberVO.getMemLat());	
			pstmt.setInt(20, memberVO.getMemPriv());	
			pstmt.setInt(21, memberVO.getMemStatus());	

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memberVO.getMemID());
			pstmt.setString(2, memberVO.getMemEmail());
			pstmt.setString(3, memberVO.getMemPw());
			pstmt.setInt(4, memberVO.getMemberType());
			pstmt.setInt(5, memberVO.getMemLv());
			pstmt.setInt(6, memberVO.getMemExp());
			pstmt.setInt(7, memberVO.getMemPt());
			pstmt.setString(8, memberVO.getMemName());
			pstmt.setInt(9, memberVO.getMemGender());
			pstmt.setDate(10, memberVO.getMemBD());
			pstmt.setInt(11, memberVO.getMemPhone());
			pstmt.setBytes(12, memberVO.getMemAvatar());
			pstmt.setDate(13, memberVO.getMemJoinDate());
			pstmt.setInt(14, memberVO.getMemLoginNum());
			pstmt.setString(15, memberVO.getMemLocBorn());
			pstmt.setString(16, memberVO.getMemLocLive());
			pstmt.setString(17, memberVO.getMemInt());
			pstmt.setDouble(18, memberVO.getMemLong());	
			pstmt.setDouble(19, memberVO.getMemLat());	
			pstmt.setInt(20, memberVO.getMemPriv());	
			pstmt.setInt(21, memberVO.getMemStatus());	

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(Integer memID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memID);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public MemberVO findByPrimaryKey(Integer memID) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// MemberVO 涔熺ū鐐� Domain objects
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// MemberVO 涔熺ū鐐� Domain objects
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

	public static void main(String[] args) {

		MemberJDBCDAO dao = new MemberJDBCDAO();

		// 鏂板
//		MemberVO MemberVO1 = new MemberVO();
//		MemberVO1.setEname("鍚虫案蹇�1");
//		MemberVO1.setJob("MANAGER");
//		MemberVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		MemberVO1.setSal(new Double(50000));
//		MemberVO1.setComm(new Double(500));
//		MemberVO1.setDeptno(10);
//		dao.insert(MemberVO1);

//		// 淇敼
//		MemberVO MemberVO2 = new MemberVO();
//		MemberVO2.setEmpno(7001);
//		MemberVO2.setEname("鍚虫案蹇�2");
//		MemberVO2.setJob("MANAGER2");
//		MemberVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		MemberVO2.setSal(new Double(20000));
//		MemberVO2.setComm(new Double(200));
//		MemberVO2.setDeptno(20);
//		dao.update(MemberVO2);

		// 鍒櫎
//		dao.delete(7014);

		// 鏌ヨ
//		MemberVO memberVO3 = dao.findByPrimaryKey(1);
//		System.out.print(memberVO3.getMemID() + ",");
//		System.out.print(memberVO3.getMemEmail() + ",");
//		System.out.print(memberVO3.getMemPw() + ",");
//		System.out.print(memberVO3.getMemberType() + ",");
//		System.out.print(memberVO3.getMemLv() + ",");
//		System.out.print(memberVO3.getMemExp() + ",");
//		System.out.println(memberVO3.getMemPt());
//		System.out.print(memberVO3.getMemName() + ",");
//		System.out.print(memberVO3.getMemGender() + ",");
//		System.out.print(memberVO3.getMemBD() + ",");
//		System.out.print(memberVO3.getMemPhone() + ",");
//		System.out.print(memberVO3.getMemAvatar() + ",");
//		System.out.print(memberVO3.getMemJoinDate() + ",");
//		System.out.print(memberVO3.getMemLoginNum());
//		System.out.print(memberVO3.getMemLocBorn() + ",");
//		System.out.print(memberVO3.getMemLocLive() + ",");
//		System.out.print(memberVO3.getMemInt() + ",");
//		System.out.print(memberVO3.getMemLong() + ",");
//		System.out.print(memberVO3.getMemLat() + ",");
//		System.out.print(memberVO3.getMemPriv() + ",");
//		System.out.print(memberVO3.getMemStatus());
//		System.out.println("---------------------");

		// 鏌ヨ
		List<MemberVO> list = dao.getAll();
		for (MemberVO member : list) {
			System.out.print(member.getMemID() + ",");
			System.out.print(member.getMemEmail() + ",");
			System.out.print(member.getMemPw() + ",");
			System.out.print(member.getMemberType() + ",");
			System.out.print(member.getMemLv() + ",");
			System.out.print(member.getMemExp() + ",");
			System.out.print(member.getMemPt());
			System.out.print(member.getMemName() + ",");
			System.out.print(member.getMemGender() + ",");
			System.out.print(member.getMemBD() + ",");
			System.out.print(member.getMemPhone() + ",");
			System.out.print(member.getMemAvatar() + ",");
			System.out.print(member.getMemJoinDate() + ",");
			System.out.print(member.getMemLoginNum());
			System.out.print(member.getMemLocBorn() + ",");
			System.out.print(member.getMemLocLive() + ",");
			System.out.print(member.getMemInt() + ",");
			System.out.print(member.getMemLong() + ",");
			System.out.print(member.getMemLat() + ",");
			System.out.print(member.getMemPriv() + ",");
			System.out.print(member.getMemStatus());
			System.out.println("---------------------");
			System.out.println();
		}
	}

	@Override
	public MemberVO findByMemEmail(String memEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByMemPw(String memPw) {
		// TODO Auto-generated method stub
		return null;
	}
}