package br.edu.infnet.appArtesanato.model.domain;

import br.edu.infnet.appArtesanato.model.exceptions.DificuldadeBolsaZeradaException;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Bolsa extends Artesanato{

    private String material;
    private String cor;
    private int dificuldade;
    private boolean comFecho;

    public Bolsa(){
    }

    public Bolsa(String nome, float preco, boolean proprio) {
        super(nome, preco, proprio);
    }

    @Override
    public float calcularValorFinal() throws DificuldadeBolsaZeradaException {

        if (this.dificuldade == 0){
            throw new DificuldadeBolsaZeradaException("A dificuldade para confecção da Bolsa está zerada. Impossível calcular valor final.");
        }

        float percentualAcrescentarMaterial;
        switch (this.material.toUpperCase()) {
            case "COURO":
                percentualAcrescentarMaterial = 0.15F;
                break;
            case "LINHA":
                percentualAcrescentarMaterial = 0.10F;
                break;
            case "TECIDO":
                percentualAcrescentarMaterial = 0.05F;
                break;
            default:
                percentualAcrescentarMaterial = 0;
                break;
        }
        float percentualAcrescentarDificuldade;
        switch (this.dificuldade) {
            case 0:
                percentualAcrescentarDificuldade = 0.00F;
                break;
            case 1:
                percentualAcrescentarDificuldade = 0.30F;
                break;
            case 2:
                percentualAcrescentarDificuldade = 0.40F;
                break;
            case 3:
                percentualAcrescentarDificuldade = 0.50F;
                break;
            default:
                percentualAcrescentarDificuldade = 0.90F;
                break;
        }
        return  (this.getValorBase() * (1 + percentualAcrescentarMaterial)) * (1 + percentualAcrescentarDificuldade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.material);
        sb.append(";");
        sb.append(this.cor);
        sb.append(";");
        sb.append(this.dificuldade);
        sb.append(";");
        sb.append(this.comFecho ? "Sim" : "Não");

        return sb.toString();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public boolean isComFecho() {
        return comFecho;
    }

    public void setComFecho(boolean comFecho) {
        this.comFecho = comFecho;
    }
}
