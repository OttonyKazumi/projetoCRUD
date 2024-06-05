package com.kaz.projetoCRUD.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaz.projetoCRUD.entity.Produto;
import com.kaz.projetoCRUD.service.ProdutosService;



@RestController
@RequestMapping("/api")
public class ProdutosController {

    private ProdutosService produtoService;

    public ProdutosController(ProdutosService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/produto")
    public List<Produto> findAll(){
        return produtoService.findAll();
    }


    @GetMapping("/produto/{produtoId}")
    public Produto getProduto(@PathVariable int produtoId){

        Produto produto = produtoService.findById(produtoId);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + produtoId);
        }
        return produto;
    }


    @PostMapping("/produto")
    public Produto addProduto(@RequestBody Produto produto){


        produto.setId(0);

        Produto dbProduto = produtoService.save(produto);

        return dbProduto;
    }

    @PutMapping("/produto")
    public Produto updateProduto(@RequestBody Produto produto){

        Produto dbProduto = produtoService.save(produto);

        return dbProduto;
    }

    @DeleteMapping("/produto/{produtoId}")
    public String deleteProduto(@PathVariable int produtoId){

        Produto tempProduto = produtoService.findById(produtoId);

        // throw exception if null

        if(tempProduto == null){
            throw new RuntimeException("Produto não encontrado - "+produtoId);
        }

        produtoService.deleteById(produtoId);

        return "Produto deletado - " + produtoId;
    }
}
