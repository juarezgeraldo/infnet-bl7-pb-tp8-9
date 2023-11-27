package br.edu.infnet.appArtesanato.model.dto;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean admin;
    private Integer qtClientes;
    private Integer qtEncomendas;
    private Integer qtArtesanatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Integer getQtClientes() {
        return qtClientes;
    }

    public void setQtClientes(Integer qtClientes) {
        this.qtClientes = qtClientes;
    }

    public Integer getQtEncomendas() {
        return qtEncomendas;
    }

    public void setQtEncomendas(Integer qtEncomendas) {
        this.qtEncomendas = qtEncomendas;
    }

    public Integer getQtArtesanatos() {
        return qtArtesanatos;
    }

    public void setQtArtesanatos(Integer qtArtesanatos) {
        this.qtArtesanatos = qtArtesanatos;
    }
}