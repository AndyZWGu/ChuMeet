package com.member.model;

import java.util.List;

public interface AchDAO_interface {
    public void insert(AchVO achVO);
    public void update(AchVO achVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public AchVO findByPrimaryKey(Integer empno);
    public List<AchVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<achVO> getAll(Map<String, String[]> map); 
}
