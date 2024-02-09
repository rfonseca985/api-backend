package com.rfonseca985.projeto_backend.controller;

import com.rfonseca985.projeto_backend.model.Produto;
import com.rfonseca985.projeto_backend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }
    @GetMapping("/{id}")
    public Optional<Produto>obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return "Produto com id: " + id + " foi deletado com sucesso";
    }
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody  Produto produto,@PathVariable Integer id){
        return produtoService.atualizar(id,produto);
    }
}
