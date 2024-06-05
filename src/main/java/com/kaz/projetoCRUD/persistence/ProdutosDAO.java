package com.kaz.projetoCRUD.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaz.projetoCRUD.entity.Produto;

@Repository
public interface ProdutosDAO extends JpaRepository <Produto, Integer> {

}
