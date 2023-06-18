package com.thiago.integration.domain.entity;

public class RbrfCpf {
    private Integer id;
    private String cpf;
    private Integer codigo;
    private String mensagem;
    private Dados dados;

    public RbrfCpf() {
    }

    public RbrfCpf(String cpf, Integer codigo, String mensagem, Dados dados) {
        this.cpf = cpf;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public RbrfCpf(Integer id, String cpf, Integer codigo, String mensagem, Dados dados) {
        this.id = id;
        this.cpf = cpf;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "ObjRbrfCpf{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", codigo=" + codigo +
                ", mensagem='" + mensagem + '\'' +
                ", dados=" + dados +
                '}';
    }
}
