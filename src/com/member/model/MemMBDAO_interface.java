package com.member.model;

import java.util.List;

public interface MemMBDAO_interface {
    public void insert(MemMBVO memMBVO);
    public void update(MemMBVO memMBVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemMBVO findByPrimaryKey(Integer empno);
    public List<MemMBVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memMBVO> getAll(Map<String, String[]> map); 
}
