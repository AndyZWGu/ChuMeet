package com.member.model;

import java.util.List;

public interface FriendsDAO_interface {
    public void insert(FriendsVO friendsVO);
    public void update(FriendsVO friendsVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public FriendsVO findByPrimaryKey(Integer empno);
    public List<FriendsVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<friendsVO> getAll(Map<String, String[]> map); 
}
