package com.member.model;

import java.util.List;

public interface MemRewardDAO_interface {
    public void insert(MemRewardVO memRewardVO);
    public void update(MemRewardVO memRewardVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemRewardVO findByPrimaryKey(Integer empno);
    public List<MemRewardVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memRewardVO> getAll(Map<String, String[]> map); 
}
