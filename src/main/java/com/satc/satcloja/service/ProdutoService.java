package com.satc.satcloja.service;

import com.satc.satcloja.model.Produto;
import com.satc.satcloja.model.QProduto;
import com.satc.satcloja.model.Status;
import com.satc.satcloja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findProdutosAlugados() {
        List<Produto> alugados = repository.
                findAll(QProduto.produto.status.in(Status.ALUGADO, Status.DISPONIVEL));
        return alugados;
    }
}


