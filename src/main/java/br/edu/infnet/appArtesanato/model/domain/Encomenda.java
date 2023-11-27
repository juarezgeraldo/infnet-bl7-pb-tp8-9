package br.edu.infnet.appArtesanato.model.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private boolean feira;
    private String observacao;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Artesanato> artesanatoList;

    public Encomenda(){
        data = LocalDate.now();
    }

    public Encomenda(LocalDate data, boolean feira, String observacao) {
        this.data = data;
        this.feira = feira;
        this.observacao = observacao;
    }

    public String obterEncomenda() {
        return String.format("Realizada por: %s - Dia: %s - Usuário: %s ===> %s",
                this.cliente.getNome(),
                this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                this.usuario.getNome(),
                this.feira ? "Pela Feira" : "Pelo Telefone");
    }

    @Override
    public String toString() {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder sb = new StringBuilder();
        sb.append(this.data.format(dataFormatada));
        sb.append(";");
        sb.append(this.feira ? "Pela Feira" : "Pelo Telefone");
        sb.append(";");
        sb.append(this.observacao);
        sb.append(";");
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isFeira() {
        return feira;
    }

    public void setFeira(boolean feira) {
        this.feira = feira;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Artesanato> getArtesanatoList() {
        return artesanatoList;
    }

    public void setArtesanatoList(List<Artesanato> artesanatoList) {
        this.artesanatoList = artesanatoList;
    }
}
