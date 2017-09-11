package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	//管理員用
    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Integer memID);
    //共用
    public MemberVO findByPrimaryKey(Integer memID);
    //會員用
//    public void registerMember(MemberVO memberVO);
//    public void updateInfo(MemberVO memberVO);
    
    
    public List<MemberVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memberVO> getAll(Map<String, String[]> map); 
}
