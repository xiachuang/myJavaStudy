package cn.briup.xia.service;

import cn.briup.xia.baen.Type;

import java.util.List;

public interface TypeService {
    public List<Type> findByAll();
    public Type findTypeById(Integer id);
    public void insertType(Type type);
}
