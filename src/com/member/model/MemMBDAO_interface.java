package com.member.model;

import java.util.List;

public interface MemMBDAO_interface {
    public void insert(MemMBVO memMBVO);
    public void update(MemMBVO memMBVO);
    //pk處理一下
    public void delete(Integer empno);
    public MemMBVO findByPrimaryKey(Integer empno);
    public List<MemMBVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memMBVO> getAll(Map<String, String[]> map); 
}
