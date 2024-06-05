package com.kaz.projetoCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaz.projetoCRUD.entity.Produto;
import com.kaz.projetoCRUD.persistence.ProdutosDAO;

@Service
public class ProdutosService implements IProdutosService{

    private ProdutosDAO produtosDAO;
        
    ProdutosService(ProdutosDAO produtosDAO){
        this.produtosDAO = produtosDAO;
    }
    
    @Override
    public List<Produto> findAll() {
        return produtosDAO.findAll();
    }

    @Override
    public Produto findById(int id) {
        Optional<Produto> result = produtosDAO.findById(id);
        Produto produto = null;

        if(result.isPresent()){
            produto = result.get();
        }else{
            throw new RuntimeException("Produto não encontrado - "+id);
        }

        return produto;
    }

    @Override
    public Produto save(Produto produto) {
        return produtosDAO.save(produto);
    }

    @Override
    public void deleteById(int id) {
        produtosDAO.deleteById(id);
    }

}
