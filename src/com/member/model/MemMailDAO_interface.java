package com.member.model;

import java.util.List;

public interface MemMailDAO_interface {
    public void insert(MemMailVO memMailVO);
    public void update(MemMailVO memMailVO);
    //pk處理一下
    public void delete(Integer empno);
    public MemMailVO findByPrimaryKey(Integer empno);
    public List<MemMailVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memMailVO> getAll(Map<String, String[]> map); 
}
