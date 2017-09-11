package com.member.model;

import java.util.List;

public interface MemRewardDAO_interface {
    public void insert(RemRewardVO memRewardVO);
    public void update(RemRewardVO memRewardVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public RemRewardVO findByPrimaryKey(Integer empno);
    public List<RemRewardVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memRewardVO> getAll(Map<String, String[]> map); 
}
