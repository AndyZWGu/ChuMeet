package com.member.model;

import java.util.List;

public interface POIDAO_interface {
    public void insert(POIVO POIVO);
    public void update(POIVO POIVO);
    //pk處理一下
    public void delete(Integer empno);
    public POIVO findByPrimaryKey(Integer empno);
    public List<POIVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<POIVO> getAll(Map<String, String[]> map); 
}
