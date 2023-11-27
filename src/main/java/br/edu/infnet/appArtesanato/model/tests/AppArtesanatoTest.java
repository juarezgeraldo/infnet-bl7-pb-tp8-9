package br.edu.infnet.appArtesanato.model.tests;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Decoracao;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.exceptions.DificuldadeBolsaZeradaException;
import br.edu.infnet.appArtesanato.model.exceptions.DivergenciaNosAcessoriosException;
import br.edu.infnet.appArtesanato.model.exceptions.QtdAcessorioZeradaOuNegativaException;
import br.edu.infnet.appArtesanato.model.exceptions.QtdPecasConjuntoDecoracaoZeradaOuNegativaException;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppArtesanatoTest {
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".txt";

        try {
            try {
                InputStream resource = new ClassPathResource("static/encomendas.txt").getInputStream();

                FileWriter fileW = new FileWriter(dir + "\\" + arq);
                BufferedWriter escrita = new BufferedWriter(fileW);

                BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

                String linha = leitura.readLine();
                Usuario usuario = new Usuario();

                while (linha != null) {

                    String[] campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "U":
//                            usuario = new Usuario(campos[1], campos[2], campos[3], "S".equalsIgnoreCase(campos[4]));
                            break;

                        case "E":
//                            Cliente cliente = new Cliente(campos[3], campos[4], campos[5]);
//
//                            Encomenda encomenda = new Encomenda();
//                            encomenda.setCliente(cliente);
//                            encomenda.setObservacao(campos[2]);
//                            encomenda.setFeira("feira".equalsIgnoreCase(campos[1]));
//                            encomenda.setUsuario(usuario);
//
//                            escrita.write(encomenda.obterEncomenda()+"\r\n");
                            break;

                        case "A":
                            Acessorio acessorio = new Acessorio(campos[1], Float.parseFloat(campos[2]), "Idelma Criações".equalsIgnoreCase(campos[3]));
                            acessorio.setTipo(campos[4]);
                            acessorio.setQuantidade(Integer.parseInt(campos[5]));
                            acessorio.setDesconto(Float.parseFloat(campos[6]));

                            escrita.write(acessorio.selecionarItemArtesanato());
                            break;

                        case "B":
                            Bolsa bolsa = new Bolsa(campos[1], Float.parseFloat(campos[2]), "Idelma Criações".equalsIgnoreCase(campos[3]));
                            bolsa.setMaterial(campos[4]);
                            bolsa.setCor(campos[5]);
                            bolsa.setDificuldade(Integer.parseInt(campos[6]));
                            bolsa.setComFecho("S".equalsIgnoreCase(campos[7]));

                            escrita.write(bolsa.selecionarItemArtesanato());
                            break;

                        case "D":
                            Decoracao decoracao = new Decoracao(campos[1], Float.parseFloat(campos[2]), "Idelma Criações".equalsIgnoreCase(campos[3]));
                            decoracao.setTipo(campos[4]);
                            decoracao.setQtdPecasConjunto(Integer.parseInt(campos[5]));
                            decoracao.setVidro("S".equalsIgnoreCase(campos[6]));

                            escrita.write(decoracao.selecionarItemArtesanato());
                            break;

                        default:
                            System.out.println("Entrada inválida!!!");
                            break;
                    }

                    linha = leitura.readLine();
                }
                leitura.close();
                escrita.close();
                fileW.close();

            } catch (IOException | QtdAcessorioZeradaOuNegativaException | QtdPecasConjuntoDecoracaoZeradaOuNegativaException | DificuldadeBolsaZeradaException | DivergenciaNosAcessoriosException e) {
                System.out.println(e.getMessage());
            }

        } finally {
            System.out.println("Processamento finalizado: "+(dir + "\\" + arq)+"!!!");
        }
    }



}
