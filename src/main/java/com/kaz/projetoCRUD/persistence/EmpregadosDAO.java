package com.kaz.projetoCRUD.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaz.projetoCRUD.entity.Empregado;

@Repository
public interface EmpregadosDAO extends JpaRepository <Empregado, Integer> {

}
