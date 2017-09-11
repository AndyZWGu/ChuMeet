package com.member.model;

import java.util.List;

public interface MemPOIDAO_interface {
    public void insert(MemPOIVO memPOIVO);
    public void update(MemPOIVO memPOIVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemPOIVO findByPrimaryKey(Integer empno);
    public List<MemPOIVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memPOIVO> getAll(Map<String, String[]> map); 
}
