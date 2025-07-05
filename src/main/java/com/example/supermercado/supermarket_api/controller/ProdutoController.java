package com.example.supermercado.supermarket_api.controller;


import com.example.supermercado.supermarket_api.model.Produto;
import com.example.supermercado.supermarket_api.repository.ProdutoRepository;
import com.example.supermercado.supermarket_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/total")
    public Integer calcularTotal() {
        return produtoService.calcularQuantidadeTotal();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    @PostMapping("/lote")
    public List<Produto> criarEmLote(@RequestBody List<Produto> produtos) {
        return produtoService.criarEmLote(produtos);
    }


    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    // Para apagar todos os dados é preciso usar http://localhost:8080/produtos/todos?confirmacao=CONFIRMO
    @DeleteMapping("/todos")
    public void deletarTodos(@RequestParam String confirmacao) {
        if (!"CONFIRMO".equals(confirmacao)) {
            throw new IllegalArgumentException("Para deletar tudo, envie ?confirmacao=CONFIRMO");
        }
        produtoService.deletarTodos();
    }




}
