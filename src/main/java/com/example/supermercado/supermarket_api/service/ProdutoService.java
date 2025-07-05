package com.example.supermercado.supermarket_api.service;


import com.example.supermercado.supermarket_api.model.Produto;
import com.example.supermercado.supermarket_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto criar (Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> criarEmLote(List<Produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }


    public Produto atualizar (Long id, Produto novoProduto) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produto.setNome(novoProduto.getNome());
            produto.setQuantidade(novoProduto.getQuantidade());
            produto.setDataCadastro(novoProduto.getDataCadastro());
            produto.setDescricao(novoProduto.getDescricao());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public Integer calcularQuantidadeTotal() {
        return produtoRepository.findAll().stream().mapToInt(Produto::getQuantidade).sum();
    }


    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public void deletarTodos() {
        produtoRepository.deleteAll();
    }
}
