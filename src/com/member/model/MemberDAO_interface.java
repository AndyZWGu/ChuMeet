package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	//����T��
    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Integer memID);
    //����
    public MemberVO findByPrimaryKey(Integer memID);
    //���T��
//    public void registerMember(MemberVO memberVO);
//    public void updateInfo(MemberVO memberVO);
    
    
    public List<MemberVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memberVO> getAll(Map<String, String[]> map); 
}
