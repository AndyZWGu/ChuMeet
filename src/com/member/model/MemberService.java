package com.member.model;

import java.sql.Date;
import java.util.List;

public class MemberService {

	private MemberDAO_interface dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberVO addMember(
			String memEmail,
			String memPw,
			Integer memberType,
			Integer memLv,
			Integer memExp,
			Integer memPt,
			String memName,
			Integer memGender,
			Date memBD, 
			Integer memPhone, 
			byte[] memAvatar,
			Date memJoinDate,
			Integer memLoginNum,
			String memLocBorn,
			String memLocLive,
			String memInt,
		 	Integer memPriv,
			Integer memStatus) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMemEmail(memEmail);
		memberVO.setMemPw(memPw);
		memberVO.setMemberType(memberType);
		memberVO.setMemLv(memLv);
		memberVO.setMemExp(memExp);
		memberVO.setMemPt(memPt);
		memberVO.setMemName(memName);
		memberVO.setMemGender(memGender);
		memberVO.setMemBD(memBD);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemAvatar(memAvatar);
		memberVO.setMemJoinDate(memJoinDate);
		memberVO.setMemLoginNum(memLoginNum);
		memberVO.setMemLocBorn(memLocBorn);
		memberVO.setMemLocLive(memLocLive);
		memberVO.setMemInt(memInt);
		memberVO.setMemPriv(memPriv);
		memberVO.setMemStatus(memStatus);
		dao.insert(memberVO);

		return memberVO;
	}

	public MemberVO updateMember(Integer memID,
			String memEmail,
			String memPw,
			Integer memberType,
			Integer memLv,
			Integer memExp,
			Integer memPt,
			String memName,
			Integer memGender,
			Date memBD, 
			Integer memPhone, 
			byte[] memAvatar,
			Date memJoinDate,
			Integer memLoginNum,
			String memLocBorn,
			String memLocLive,
			String memInt,
		 	Integer memPriv,
			Integer memStatus) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMemID(memID);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemPw(memPw);
		memberVO.setMemberType(memberType);
		memberVO.setMemLv(memLv);
		memberVO.setMemExp(memExp);
		memberVO.setMemPt(memPt);
		memberVO.setMemName(memName);
		memberVO.setMemGender(memGender);
		memberVO.setMemBD(memBD);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemAvatar(memAvatar);
		memberVO.setMemJoinDate(memJoinDate);
		memberVO.setMemLoginNum(memLoginNum);
		memberVO.setMemLocBorn(memLocBorn);
		memberVO.setMemLocLive(memLocLive);
		memberVO.setMemInt(memInt);
		memberVO.setMemPriv(memPriv);
		memberVO.setMemStatus(memStatus);
		dao.update(memberVO);

		return memberVO;
	}

	public void deleteMember(Integer memID) {
		dao.delete(memID);
	}

	public MemberVO getOneMember(Integer memID) {
		return dao.findByPrimaryKey(memID);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	public MemberVO getMemberByMemEmail(String memEmail) {
		return dao.findByMemEmail(memEmail);
	}
	public MemberVO getMemberByMemPw(String memPw) {
		return dao.findByMemPw(memPw);
	}
}
