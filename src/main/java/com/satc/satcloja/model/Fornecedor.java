package com.satc.satcloja.model;

public class Fornecedor extends Pessoa {
    private String cnpj;
    private String incricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIncricaoEstadual() {
        return incricaoEstadual;
    }

    public void setIncricaoEstadual(String incricaoEstadual) {
        this.incricaoEstadual = incricaoEstadual;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCnpj();
    }


}

