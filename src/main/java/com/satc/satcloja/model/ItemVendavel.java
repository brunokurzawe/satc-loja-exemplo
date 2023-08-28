package com.satc.satcloja.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ItemVendavel extends EntityId {

    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;
    @Column(name = "estocavel", nullable = true)
    private Boolean estocavel;

    public Boolean getEstocavel() {
        return estocavel;
    }

    public void setEstocavel(Boolean estocavel) {
        this.estocavel = estocavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}


