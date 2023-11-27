package br.edu.infnet.appArtesanato.model.domain;

import br.edu.infnet.appArtesanato.model.exceptions.DivergenciaNosAcessoriosException;
import br.edu.infnet.appArtesanato.model.exceptions.QtdAcessorioZeradaOuNegativaException;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Acessorio extends Artesanato {

    private String tipo;
    private int quantidade;
    private float desconto;

    public Acessorio() {
    }

    public Acessorio(String nome, float preco, boolean proprio) {
        super(nome, preco, proprio);
    }

    @Override
    public float calcularValorFinal() throws QtdAcessorioZeradaOuNegativaException, DivergenciaNosAcessoriosException {
        if (this.quantidade <= 0) {
            throw new QtdAcessorioZeradaOuNegativaException("Quantidade de acessórios está zerado ou negativo: " + this.quantidade);
        }

        if ("brinco".equalsIgnoreCase(this.tipo) && this.quantidade != 2) {
            throw new DivergenciaNosAcessoriosException("Para brincos a quantidade deve ser igual a 2. A quantidade informada é " + this.quantidade);
        } else if ("anel".equalsIgnoreCase(this.tipo) && this.quantidade != 1) {
            throw new DivergenciaNosAcessoriosException("Para aneis a quantidade deve ser igual a 1. A quantidade informada é " + this.quantidade);
        }

        return (this.getValorBase() * this.quantidade) - this.desconto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.tipo);
        sb.append(";");
        sb.append(this.quantidade);
        sb.append(";");
        sb.append(this.desconto);

        return sb.toString();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }


}
