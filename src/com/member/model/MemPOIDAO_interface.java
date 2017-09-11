package com.member.model;

import java.util.List;

public interface MemPOIDAO_interface {
    public void insert(MemPOIVO memPOIVO);
    public void update(MemPOIVO memPOIVO);
    //pk處理一下
    public void delete(Integer empno);
    public MemPOIVO findByPrimaryKey(Integer empno);
    public List<MemPOIVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memPOIVO> getAll(Map<String, String[]> map); 
}
