package com.thiago.integration.domain.entity;

public class Dados {

    private Integer codSituacaoReceita;
    private String descSituacaoReceita;
    private String dataConsulta;
    private String nome;
    private String dtNascimento;
    private String sexo;
    private String nomeMae;
    private String tituloEleitor;
    private String resideExterior;
    private String anoObito;
    private String dtAtualizacao;
    private String isClienteValido;
    private String isNomeValido;
    private String isDataNascimentoValida;

    public Dados() {
    }

    public Dados(Integer codSituacaoReceita, String descSituacaoReceita, String dataConsulta, String nome, String dtNascimento, String sexo, String nomeMae, String tituloEleitor, String resideExterior, String anoObito, String dtAtualizacao, String isClienteValido, String isNomeValido, String isDataNascimentoValida) {
        this.codSituacaoReceita = codSituacaoReceita;
        this.descSituacaoReceita = descSituacaoReceita;
        this.dataConsulta = dataConsulta;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.tituloEleitor = tituloEleitor;
        this.resideExterior = resideExterior;
        this.anoObito = anoObito;
        this.dtAtualizacao = dtAtualizacao;
        this.isClienteValido = isClienteValido;
        this.isNomeValido = isNomeValido;
        this.isDataNascimentoValida = isDataNascimentoValida;
    }

    public Integer getCodSituacaoReceita() {
        return codSituacaoReceita;
    }

    public void setCodSituacaoReceita(Integer codSituacaoReceita) {
        this.codSituacaoReceita = codSituacaoReceita;
    }

    public String getDescSituacaoReceita() {
        return descSituacaoReceita;
    }

    public void setDescSituacaoReceita(String descSituacaoReceita) {
        this.descSituacaoReceita = descSituacaoReceita;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getResideExterior() {
        return resideExterior;
    }

    public void setResideExterior(String resideExterior) {
        this.resideExterior = resideExterior;
    }

    public String getAnoObito() {
        return anoObito;
    }

    public void setAnoObito(String anoObito) {
        this.anoObito = anoObito;
    }

    public String getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(String dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public String getIsClienteValido() {
        return isClienteValido;
    }

    public void setIsClienteValido(String isClienteValido) {
        this.isClienteValido = isClienteValido;
    }

    public String getIsNomeValido() {
        return isNomeValido;
    }

    public void setIsNomeValido(String isNomeValido) {
        this.isNomeValido = isNomeValido;
    }

    public String getIsDataNascimentoValida() {
        return isDataNascimentoValida;
    }

    public void setIsDataNascimentoValida(String isDataNascimentoValida) {
        this.isDataNascimentoValida = isDataNascimentoValida;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "codSituacaoReceita=" + codSituacaoReceita +
                ", descSituacaoReceita='" + descSituacaoReceita + '\'' +
                ", dataConsulta='" + dataConsulta + '\'' +
                ", nome='" + nome + '\'' +
                ", dtNascimento='" + dtNascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", tituloEleitor=" + tituloEleitor +
                ", resideExterior='" + resideExterior + '\'' +
                ", anoObito=" + anoObito +
                ", dtAtualizacao='" + dtAtualizacao + '\'' +
                ", isClienteValido='" + isClienteValido + '\'' +
                ", isNomeValido='" + isNomeValido + '\'' +
                ", isDataNascimentoValida='" + isDataNascimentoValida + '\'' +
                '}';
    }
}
