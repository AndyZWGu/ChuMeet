package com.member.model;

import java.util.List;

public interface MemNFDAO_interface {
    public void insert(MemNFVO memNFVO);
    public void update(MemNFVO memNFVO);
    //pk̎��һ��
    public void delete(Integer empno);
    public MemNFVO findByPrimaryKey(Integer empno);
    public List<MemNFVO> getAll();
    //�f���}�ϲ�ԃ(���녢���͑BMap)(�؂� List)
//  public List<memNFVO> getAll(Map<String, String[]> map); 
}