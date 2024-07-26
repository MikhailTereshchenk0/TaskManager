package com.taskmanager.dao;

import java.util.List;

public interface IDao <T>{
    void create(T t);
    List<T> findAll();
    void delete(String id);
}
