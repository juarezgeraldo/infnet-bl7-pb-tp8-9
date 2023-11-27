package br.edu.infnet.appArtesanato.model.domain;

import br.edu.infnet.appArtesanato.model.exceptions.DificuldadeBolsaZeradaException;
import br.edu.infnet.appArtesanato.model.exceptions.DivergenciaNosAcessoriosException;
import br.edu.infnet.appArtesanato.model.exceptions.QtdAcessorioZeradaOuNegativaException;
import br.edu.infnet.appArtesanato.model.exceptions.QtdPecasConjuntoDecoracaoZeradaOuNegativaException;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Artesanato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float valorBase;
    private boolean proprio;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToMany(mappedBy = "artesanatoList")
    private List<Encomenda> encomendaList;

    public Artesanato(){
    }
    public Artesanato(String nome, float valorBase, boolean proprio) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.proprio = proprio;
    }

    public String selecionarItemArtesanato() throws QtdAcessorioZeradaOuNegativaException, QtdPecasConjuntoDecoracaoZeradaOuNegativaException, DificuldadeBolsaZeradaException, DivergenciaNosAcessoriosException {

        DecimalFormat formato = new DecimalFormat("R$ #,##0.00");

        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.proprio ? "Idelma Criações" : "Outro fornecedor");
        sb.append(";");
        sb.append(formato.format(this.calcularValorFinal()));
        sb.append("\r\n");

        return sb.toString();
    }

    public abstract float calcularValorFinal() throws DificuldadeBolsaZeradaException, QtdPecasConjuntoDecoracaoZeradaOuNegativaException, QtdAcessorioZeradaOuNegativaException, DivergenciaNosAcessoriosException;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.valorBase);
        sb.append(";");
        sb.append(this.proprio ? "Sim" : "Não");

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

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public boolean isProprio() {
        return proprio;
    }

    public void setProprio(boolean proprio) {
        this.proprio = proprio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
