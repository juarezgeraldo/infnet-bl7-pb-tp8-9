package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @GetMapping(value = "/acessorio")
    public String telaCadastro() {
        return "/acessorio/cadastro";
    }

    @GetMapping("/acessorio/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", acessorioService.obterLista(usuario));
        return "/acessorio/lista";
    }

    @PostMapping("/acessorio/incluir")
    public String incluir(Model model, Acessorio acessorio, @SessionAttribute("user") Usuario usuario) {
        new Acessorio(acessorio.getNome(), acessorio.getValorBase(), acessorio.isProprio());
        acessorio.setUsuario(usuario);
        acessorioService.incluir(acessorio);
        String mensagem = "O acessório " + acessorio.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/acessorio/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Acessorio acessorio = acessorioService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            acessorioService.excluir(id);
            mensagem = "O acessório " + acessorio.getNome() + " foi excluído com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão do acessório " + acessorio.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
