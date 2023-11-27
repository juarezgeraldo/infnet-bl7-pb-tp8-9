package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Decoracao;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.DecoracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DecoracaoController {

    @Autowired
    private DecoracaoService decoracaoService;

    @GetMapping(value = "/decoracao")
    public String telaCadastro() {
        return "/decoracao/cadastro";
    }

    @GetMapping("/decoracao/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", decoracaoService.obterLista(usuario));
        return "/decoracao/lista";
    }

    @PostMapping("/decoracao/incluir")
    public String incluir(Model model, Decoracao decoracao, @SessionAttribute("user") Usuario usuario) {
        new Decoracao(decoracao.getNome(), decoracao.getValorBase(), decoracao.isProprio());
        decoracao.setUsuario(usuario);
        decoracaoService.incluir(decoracao);
        String mensagem = "A decoração " + decoracao.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/decoracao/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Decoracao decoracao = decoracaoService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            decoracaoService.excluir(id);
            mensagem = "A decoração  " + decoracao.getNome() + " foi excluída com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão da decoração " + decoracao.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }

}
