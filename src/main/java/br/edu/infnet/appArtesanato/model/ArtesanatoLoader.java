package br.edu.infnet.appArtesanato.model;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Decoracao;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.AcessorioService;
import br.edu.infnet.appArtesanato.model.service.BolsaService;
import br.edu.infnet.appArtesanato.model.service.DecoracaoService;
import br.edu.infnet.appArtesanato.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ArtesanatoLoader implements ApplicationRunner {
    @Autowired
    private AcessorioService acessorioService;

    @Autowired
    private BolsaService bolsaService;

    @Autowired
    private DecoracaoService decoracaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Acessorio acessorio = new Acessorio();
        Bolsa bolsa = new Bolsa();
        Decoracao decoracao = new Decoracao();

        Usuario usuario = usuarioService.findById(1L);

        acessorio.setNome("Brincos de princesa");
        acessorio.setProprio(true);
        acessorio.setValorBase(45.67F);
        acessorio.setUsuario(usuario);
        acessorio.setTipo("Brinco");
        acessorio.setQuantidade(2);
        acessorio.setDesconto(0.00F);
        acessorioService.incluir(acessorio);


        bolsa.setNome("Bolsa de couro verde");
        bolsa.setProprio(false);
        bolsa.setValorBase(235.00F);
        bolsa.setUsuario(usuario);
        bolsa.setMaterial("Couro");
        bolsa.setCor("Verde");
        bolsa.setDificuldade(3);
        bolsa.setComFecho(true);
        bolsaService.incluir(bolsa);

        decoracao.setNome("Vaso pintado colorido");
        decoracao.setProprio(true);
        decoracao.setValorBase(24.00F);
        decoracao.setUsuario(usuario);
        decoracao.setTipo("Vaso");
        decoracao.setVidro(true);
        decoracao.setQtdPecasConjunto(1);
        decoracaoService.incluir(decoracao);

        System.out.println("Inclusão de artesanato realizada!!!");

    }
}
