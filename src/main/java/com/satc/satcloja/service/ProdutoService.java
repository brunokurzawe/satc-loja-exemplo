package com.satc.satcloja.service;

import com.satc.satcloja.enterprise.NotFoundException;
import com.satc.satcloja.enterprise.ValidationException;
import com.satc.satcloja.model.Produto;
import com.satc.satcloja.model.QProduto;
import com.satc.satcloja.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {

        if (entity.getValorUnitario() < entity.getPrecoCompra()) {
            throw new ValidationException("O valor unitario não pode ser menor que o preço de compra do produto!");
        }

        if (!repository.findAll(QProduto.produto.descricao.eq(entity.getDescricao())).isEmpty()) {
            throw new ValidationException("Já existe um produto com essa descrição cadastrado!");
        }

        if (!repository.findAll(QProduto.produto.nome.eq(entity.getNome())).isEmpty()) {
            throw new ValidationException("Já existe um produto com essa nome cadastrado!");
        }

        if (entity.getNome() == null) {

        }

        return repository.save(entity);
    }

    public List<Produto> buscaTodos(String filter) {
        return repository.findAll(filter, Produto.class);
    }

    public Page<Produto> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Produto.class, pageable);
    }

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto entity) {
        Optional<Produto> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }

        Produto existingProduto = byId.get();
        modelMapper.map(entity, existingProduto);

        return repository.save(existingProduto);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}


