package com.member.model;

import java.util.List;

public interface MemRewardDAO_interface {
    public void insert(RemRewardVO memRewardVO);
    public void update(RemRewardVO memRewardVO);
    //pk處理一下
    public void delete(Integer empno);
    public RemRewardVO findByPrimaryKey(Integer empno);
    public List<RemRewardVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<memRewardVO> getAll(Map<String, String[]> map); 
}
