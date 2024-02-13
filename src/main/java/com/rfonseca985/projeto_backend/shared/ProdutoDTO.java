package com.rfonseca985.projeto_backend.shared;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * DTO (Data Transfer Object) para a entidade Produto.
 */
public class ProdutoDTO {


    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;

    /**
     * Obtém o ID do produto.
     *
     * @return O ID do produto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id O novo ID do produto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a quantidade do produto.
     *
     * @return A quantidade do produto.
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do produto.
     *
     * @param quantidade A nova quantidade do produto.
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o valor do produto.
     *
     * @return O valor do produto.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Define o valor do produto.
     *
     * @param valor O novo valor do produto.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtém a observação do produto.
     *
     * @return A observação do produto.
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define a observação do produto.
     *
     * @param observacao A nova observação do produto.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
