package com.member.model;

import java.util.List;

public interface MemNFDAO_interface {
    public void insert(MemNFVO memNFVO);
    public void update(MemNFVO memNFVO);
    //pk處理一下
    public void delete(Integer empno);
    public MemNFVO findByPrimaryKey(Integer empno);
    public List<MemNFVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memNFVO> getAll(Map<String, String[]> map); 
}
