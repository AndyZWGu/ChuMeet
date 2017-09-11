package com.member.model;

import java.util.List;

public interface MemAchDAO_interface {
    public void insert(MemAchVO memAchVO);
    public void update(MemAchVO memAchVO);
    //pk處理一下
    public void delete(Integer empno);
    public MemAchVO findByPrimaryKey(Integer empno);
    public List<MemAchVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memAchVO> getAll(Map<String, String[]> map); 
}
