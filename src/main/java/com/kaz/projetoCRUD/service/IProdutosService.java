package com.kaz.projetoCRUD.service;

import java.util.List;

import com.kaz.projetoCRUD.entity.Produto;

public interface IProdutosService {
    List<Produto> findAll();
    Produto findById(int id);
    Produto save(Produto empregado);
    void deleteById(int id);
}
