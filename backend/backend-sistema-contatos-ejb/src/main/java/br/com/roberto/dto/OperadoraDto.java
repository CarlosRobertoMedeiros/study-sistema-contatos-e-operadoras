package br.com.roberto.dto;

import br.com.roberto.entity.Categoria;

import java.math.BigDecimal;
import java.util.Objects;

public class OperadoraDto {

    private Integer codigo;
    private String nome;
    private Categoria categoria;
    private BigDecimal preco;

    public OperadoraDto() {
    }

    public OperadoraDto(Integer codigo, String nome, Categoria categoria, BigDecimal preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperadoraDto that = (OperadoraDto) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
