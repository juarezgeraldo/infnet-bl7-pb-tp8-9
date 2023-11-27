package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.BolsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BolsaController {

    @Autowired
    private BolsaService bolsaService;

    @GetMapping(value = "/bolsa")
    public String telaCadastro() {
        return "/bolsa/cadastro";
    }

    @GetMapping("/bolsa/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", bolsaService.obterLista(usuario));
        return "/bolsa/lista";
    }

    @PostMapping("/bolsa/incluir")
    public String incluir(Model model, Bolsa bolsa, @SessionAttribute("user") Usuario usuario) {
        new Bolsa(bolsa.getNome(), bolsa.getValorBase(), bolsa.isProprio());
        bolsa.setUsuario(usuario);
        bolsaService.incluir(bolsa);
        String mensagem = "O acessório " + bolsa.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/bolsa/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Bolsa bolsa = bolsaService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            bolsaService.excluir(id);
            mensagem = "A bolsa " + bolsa.getNome() + " foi excluída com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão da bolsa " + bolsa.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
