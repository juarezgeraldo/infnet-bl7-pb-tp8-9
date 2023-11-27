package br.edu.infnet.appArtesanato.model.tests;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Decoracao;

public class ArtesanatoTest {
    public static void main(String[] args) {

        try {
            Acessorio acessorio1 = new Acessorio("Brinco pingente", 5.30F, true);
            acessorio1.setTipo("Brinco");
            acessorio1.setQuantidade(2);
            acessorio1.setDesconto(0.0F);
            System.out.printf("%s: %s", acessorio1.getTipo(), acessorio1.selecionarItemArtesanato());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            Acessorio acessorio2 = new Acessorio("Brinco grande", 6.85F, false);
            acessorio2.setTipo("Brinco");
            acessorio2.setQuantidade(2);
            acessorio2.setDesconto(1.5F);
            System.out.printf("%s: %s", acessorio2.getTipo(), acessorio2.selecionarItemArtesanato());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            Acessorio acessorio3 = new Acessorio("Brinco diferente", 3.35F, true);
            acessorio3.setTipo("Brinco");
            acessorio3.setQuantidade(3);
            acessorio3.setDesconto(0.0F);
            System.out.printf("%s: %s", acessorio3.getTipo(), acessorio3.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Acessorio acessorio4 = new Acessorio("Brinco perfeito", 2.30F, true);
            acessorio4.setTipo("Brinco");
            acessorio4.setQuantidade(0);
            acessorio4.setDesconto(0.50F);
            System.out.printf("%s: %s", acessorio4.getTipo(), acessorio4.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Acessorio acessorio5 = new Acessorio("Anel aparador", 15.45F, false);
            acessorio5.setTipo("Anel");
            acessorio5.setQuantidade(1);
            acessorio5.setDesconto(1.35F);
            System.out.printf("%s: %s", acessorio5.getTipo(), acessorio5.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Acessorio acessorio5 = new Acessorio("Gargantilha", 9.50F, true);
            acessorio5.setTipo("Colar");
            acessorio5.setQuantidade(3);
            acessorio5.setDesconto(1.35F);
            System.out.printf("%s: %s", acessorio5.getTipo(), acessorio5.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Bolsa bolsa1 = new Bolsa("Bolsa jovem", 55.50F, true);
            bolsa1.setMaterial("Tecido");
            bolsa1.setCor("Azul");
            bolsa1.setDificuldade(1);
            bolsa1.setComFecho(false);
            System.out.printf("%s: %s", bolsa1.getNome(), bolsa1.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Bolsa bolsa2 = new Bolsa("Bolsa executiva", 90.00F, false);
            bolsa2.setMaterial("Couro");
            bolsa2.setCor("Marrom");
            bolsa2.setDificuldade(3);
            bolsa2.setComFecho(true);
            System.out.printf("%s: %s", bolsa2.getNome(), bolsa2.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Bolsa bolsa3 = new Bolsa("Bolsa casual", 60.00F, false);
            bolsa3.setMaterial("Linha");
            bolsa3.setCor("Amarela");
            bolsa3.setDificuldade(2);
            bolsa3.setComFecho(false);
            System.out.printf("%s: %s", bolsa3.getNome(), bolsa3.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Bolsa bolsa4 = new Bolsa("Bolsa elegante", 153.25F, true);
            bolsa4.setMaterial("Linha");
            bolsa4.setCor("Vermelha");
            bolsa4.setDificuldade(0);
            bolsa4.setComFecho(true);
            System.out.printf("%s: %s", bolsa4.getNome(), bolsa4.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Decoracao decoracao1 = new Decoracao("Vaso de plantas", 25.40F, true);
            decoracao1.setTipo("Vaso");
            decoracao1.setVidro(true);
            decoracao1.setQtdPecasConjunto(1);
            System.out.printf("%s: %s", decoracao1.getTipo(), decoracao1.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Decoracao decoracao2 = new Decoracao("Jogo de chá pintado", 63.95F, true);
            decoracao2.setTipo("Jogo");
            decoracao2.setQtdPecasConjunto(4);
            decoracao2.setVidro(true);
            System.out.printf("%s: %s", decoracao2.getTipo(), decoracao2.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Decoracao decoracao3 = new Decoracao("Quadro decorado", 30.50F, false);
            decoracao3.setTipo("Quadro");
            decoracao3.setQtdPecasConjunto(0);
            decoracao3.setVidro(false);
            System.out.printf("%s: %s", decoracao3.getTipo(), decoracao3.selecionarItemArtesanato());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
