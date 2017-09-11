package com.member.model;

import java.util.List;

public interface MemMailDAO_interface {
    public void insert(MemMailVO memMailVO);
    public void update(MemMailVO memMailVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemMailVO findByPrimaryKey(Integer empno);
    public List<MemMailVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memMailVO> getAll(Map<String, String[]> map); 
}
