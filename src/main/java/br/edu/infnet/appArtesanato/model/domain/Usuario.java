package br.edu.infnet.appArtesanato.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@SequenceGenerator(name = "idUsuarioCadastro")
public class Usuario implements Serializable, Comparable<Usuario> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    private boolean admin;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Artesanato> artesanatoList;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Encomenda> encomendaList;

    public Usuario(){
    }

    @Override
    public int compareTo(Usuario usuario) {
        return this.getNome().compareTo(usuario.getNome());
    }

    public Usuario(String nome, String email, String senha, boolean admin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.email);
        sb.append(";");
        sb.append(this.admin ? "Administrador" : "Usuário");
        return sb.toString();
    }

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

    public List<Artesanato> getArtesanatoList() {
        return artesanatoList;
    }

    public void setArtesanatoList(List<Artesanato> artesanatoList) {
        this.artesanatoList = artesanatoList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Encomenda> getEncomendaList() {
        return encomendaList;
    }

    public void setEncomendaList(List<Encomenda> encomendaList) {
        this.encomendaList = encomendaList;
    }
}
