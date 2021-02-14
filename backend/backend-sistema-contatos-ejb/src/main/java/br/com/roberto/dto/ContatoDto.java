package br.com.roberto.dto;

import br.com.roberto.entity.Operadora;

import java.time.LocalDateTime;
import java.util.Objects;

public class ContatoDto {

    private Long id;
    private String serial;
    private String nome;
    private String telefone;
    private LocalDateTime data = LocalDateTime.now();
    private Operadora operadora;

    public ContatoDto() {
    }

    public ContatoDto(Long id, String serial, String nome, String telefone, Operadora operadora) {
        this.id = id;
        this.serial = serial;
        this.nome = nome;
        this.telefone = telefone;
        this.operadora = operadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoDto that = (ContatoDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
