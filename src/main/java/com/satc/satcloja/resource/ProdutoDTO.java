package com.satc.satcloja.resource;

import com.satc.satcloja.model.Produto;
import com.satc.satcloja.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    private Long id;
    //private String nome;
    private String descricao;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static ProdutoDTO fromEntity(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
      //  dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setStatus(produto.getStatus());
        return dto;
    }

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setId(this.getId());
      //  produto.setNome(this.getNome());
        produto.setDescricao(this.getDescricao());
        produto.setStatus(this.getStatus());
        return produto;
    }

    public static List<ProdutoDTO> fromEntity(List<Produto> produtos) {
        return produtos.stream().map(produto -> fromEntity(produto)).collect(Collectors.toList());
    }

    public static Page<ProdutoDTO> fromEntity(Page<Produto> produtos) {
        List<ProdutoDTO> produtosFind = produtos.stream().map(produto -> fromEntity(produto)).collect(Collectors.toList());
        Page<ProdutoDTO> produtosDTO = new PageImpl<>(produtosFind, produtos.getPageable(), produtos.getTotalElements());
        return produtosDTO;
    }

}
