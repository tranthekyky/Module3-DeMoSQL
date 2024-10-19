package com.waggy.javacasestudy.service;

import java.util.List;

public interface IService <P>{
    List<P> getAll();
    P getById(int id);
    void save(P p);
    void delete(int id);
    void update(int id ,P p);
}
