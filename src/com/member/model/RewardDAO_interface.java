package com.member.model;

import java.util.List;

public interface RewardDAO_interface {
    public void insert(RewardVO rewardVO);
    public void update(RewardVO rewardVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public RewardVO findByPrimaryKey(Integer empno);
    public List<RewardVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<rewardVO> getAll(Map<String, String[]> map); 
}
