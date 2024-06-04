package com.kaz.projetoCRUD.service;

import java.util.List;

import com.kaz.projetoCRUD.entity.Empregado;

public interface IEmpregadosService {
    List<Empregado> findAll();
    Empregado findById(int id);
    Empregado save(Empregado empregado);
    void deleteById(int id);
}
