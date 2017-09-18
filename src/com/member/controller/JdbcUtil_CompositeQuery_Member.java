/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *        所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */

package com.member.controller;

import java.util.*;

public class JdbcUtil_CompositeQuery_Member {

	public static String get_aCondition_For_Oracle(String tableName, String columnName, String value) {

		String aCondition = null;

		//Member會員表
		if (tableName == "Member") {
			if ("memID".equals(columnName) || "memberType".equals(columnName) || "memLv".equals(columnName)
					|| "memExp".equals(columnName)|| "memPt".equals(columnName)
					|| "memGender".equals(columnName)|| "memPhone".equals(columnName)
					|| "memLoginNum".equals(columnName)|| "memLong".equals(columnName)
					|| "memLat".equals(columnName)|| "memPriv".equals(columnName)
					|| "memStatus".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("memEmail".equals(columnName) || "memPw".equals(columnName)
					|| "memName".equals(columnName)|| "memLocBorn".equals(columnName)
					|| "memLocLive".equals(columnName)|| "memInt".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("memBD".equals(columnName)|| "memJoinDate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//Friends好友表
		if (tableName == "Friends") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemMail會員郵件表
		if (tableName == "MemMail") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemNF會員動態表
		if (tableName == "MemNF") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemMB會員留言表
		if (tableName == "MemMB") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemPOI會員興趣表
		if (tableName == "MemPOI") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//Ach成就表
		if (tableName == "Ach") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemAch會員成就表
		if (tableName == "MemAch") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//Reward獎賞表
		if (tableName == "Reward") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		//MemReward會員獎賞表
		if (tableName == "MemReward") {
			if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName)
					|| "deptno".equals(columnName)) // 用於其他
				aCondition = columnName + "=" + value;
			else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
				aCondition = columnName + " like '%" + value + "%'";
			else if ("hiredate".equals(columnName)) // 用於Oracle的date
				aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
		}
		// if ("empno".equals(columnName) || "sal".equals(columnName) ||
		// "comm".equals(columnName) || "deptno".equals(columnName)) // 用於其他
		// aCondition = columnName + "=" + value;
		// else if ("ename".equals(columnName) || "job".equals(columnName)) //
		// 用於varchar
		// aCondition = columnName + " like '%" + value + "%'";
		// else if ("hiredate".equals(columnName)) // 用於Oracle的date
		// aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value +
		// "'";

		return aCondition + " ";
	}

	//DAO複合查詢用
	public static String get_WhereCondition(String tableName,Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_Oracle(tableName,key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("有送出查詢資料的欄位數count = " + count);
			}
		}

		return whereCondition.toString();
	}

	public static void main(String argv[]) {

		// 配合 req.getParameterMap()方法 回傳
		// java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("empno", new String[] { "7001" });
//		map.put("ename", new String[] { "KING" });
//		map.put("job", new String[] { "PRESIDENT" });
//		map.put("hiredate", new String[] { "1981-11-17" });
//		map.put("sal", new String[] { "5000.5" });
//		map.put("comm", new String[] { "0.0" });
//		map.put("deptno", new String[] { "10" });
//		map.put("action", new String[] { "getXXX" }); // 注意Map裡面會含有action的key
//
//		String finalSQL = "select * from emp2 " + jdbcUtil_CompositeQuery_Emp2.get_WhereCondition(map)
//				+ "order by empno";
//		System.out.println("●●finalSQL = " + finalSQL);

	}
}
