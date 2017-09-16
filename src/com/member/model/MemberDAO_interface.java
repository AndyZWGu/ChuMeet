package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	//管理員用
    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Integer memID);
    public MemberVO findByPrimaryKey(Integer memID);
    //會員用
    public MemberVO findByMemEmail(String memEmail);
    public MemberVO findByMemPw(String memPw);
    //會員拿照片用
    public List<String> getAvatarByMemID(Integer memID);
    //會員註冊用
//    public void registerMember(MemberVO memberVO);
//    public void updateInfo(MemberVO memberVO);
    
    
    public List<MemberVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memberVO> getAll(Map<String, String[]> map); 
}
