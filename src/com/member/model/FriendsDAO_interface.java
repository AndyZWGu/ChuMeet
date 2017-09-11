package com.member.model;

import java.util.List;

public interface FriendsDAO_interface {
    public void insert(FriendsVO friendsVO);
    public void update(FriendsVO friendsVO);
    //pk處理一下
    public void delete(Integer empno);
    public FriendsVO findByPrimaryKey(Integer empno);
    public List<FriendsVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<friendsVO> getAll(Map<String, String[]> map); 
}
