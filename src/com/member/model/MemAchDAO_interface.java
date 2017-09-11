package com.member.model;

import java.util.List;

public interface MemAchDAO_interface {
    public void insert(MemAchVO memAchVO);
    public void update(MemAchVO memAchVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemAchVO findByPrimaryKey(Integer empno);
    public List<MemAchVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memAchVO> getAll(Map<String, String[]> map); 
}
