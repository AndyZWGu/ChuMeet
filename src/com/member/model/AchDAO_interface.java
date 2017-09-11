package com.member.model;

import java.util.List;

public interface AchDAO_interface {
    public void insert(AchVO achVO);
    public void update(AchVO achVO);
    //pk處理一下
    public void delete(Integer empno);
    public AchVO findByPrimaryKey(Integer empno);
    public List<AchVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<achVO> getAll(Map<String, String[]> map); 
}
