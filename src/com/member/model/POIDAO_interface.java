package com.member.model;

import java.util.List;

public interface POIDAO_interface {
    public void insert(POIVO POIVO);
    public void update(POIVO POIVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public POIVO findByPrimaryKey(Integer empno);
    public List<POIVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<POIVO> getAll(Map<String, String[]> map); 
}
