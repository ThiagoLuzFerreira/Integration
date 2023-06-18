package com.thiago.integration.adapter.dto;

public class RbrfCpfDto {

    private Integer codigo;
    private String mensagem;
    private DadosDto dados;

    public RbrfCpfDto() {
    }

    public RbrfCpfDto(Integer codigo, String mensagem, DadosDto dados) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public DadosDto getDados() {
        return dados;
    }

    public void setDados(DadosDto dados) {
        this.dados = dados;
    }
}
