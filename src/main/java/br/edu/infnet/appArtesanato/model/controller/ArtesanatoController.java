package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Artesanato;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.ArtesanatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ArtesanatoController {

    @Autowired
    private ArtesanatoService artesanatoService;

    @GetMapping(value = "/artesanato")
    public String telaCadastro() {
        return "/artesanato/cadastro";
    }

    @GetMapping("/artesanato/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", artesanatoService.obterLista(usuario.getId()));
        return "/artesanato/lista";
    }

    @GetMapping("/artesanato/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Artesanato artesanato = artesanatoService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            artesanatoService.excluir(id);
            mensagem = "O artesanato " + artesanato.getNome() + " foi excluído com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão do artesanato " + artesanato.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
