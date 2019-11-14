package br.com.clientes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.type.CharArrayType;

@Table(name = "clientes")
@Entity
public class ClientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idClientes")
    private Long idClientes;

    @Column(name = "nome")
    private String nome;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private CharArrayType senha;

    @Column(name = "rua")
    private String rua;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private Long cep;

    @Column(name = "estado")
    private String estado;

    public Long getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CharArrayType getSenha() {
        return senha;
    }

    public void setSenha(CharArrayType senha) {
        this.senha = senha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClientesEntity [idClientes=");
        builder.append(idClientes);
        builder.append(", nome=");
        builder.append(nome);
        builder.append(", email=");
        builder.append(email);
        builder.append(", senha=");
        builder.append(senha);
        builder.append(", rua=");
        builder.append(rua);
        builder.append(", cidade=");
        builder.append(cidade);
        builder.append(", bairro=");
        builder.append(bairro);
        builder.append(", cep=");
        builder.append(cep);
        builder.append(", estado=");
        builder.append(estado);
        builder.append("]");
        return builder.toString();
    }

}
