package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Artesanato;
import br.edu.infnet.appArtesanato.model.domain.Encomenda;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.ArtesanatoService;
import br.edu.infnet.appArtesanato.model.service.ClienteService;
import br.edu.infnet.appArtesanato.model.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;
    @Autowired
    private ArtesanatoService artesanatoService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/encomenda")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("clientes", clienteService.obterLista(usuario));
        model.addAttribute("artesanatos", artesanatoService.obterLista(usuario.getId()));
        return "/encomenda/cadastro";
    }

    @GetMapping("/encomenda/lista")
    public String telaLista(Model model, Encomenda encomenda, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", encomendaService.obterLista(usuario));
        return "/encomenda/lista";
    }

    @PostMapping("/encomenda/incluir")
    public String incluir(Model model, Encomenda encomenda, @RequestParam String[] idArtesanato, @SessionAttribute("user") Usuario usuario) {
        List<Artesanato> artesanatoList = new ArrayList<Artesanato>();
        for (String id : idArtesanato) {
            artesanatoList.add(artesanatoService.findById(Long.valueOf(id)));
        }
        encomenda.setArtesanatoList(artesanatoList);
        encomenda.setUsuario(usuario);
        encomendaService.incluir(encomenda);
        encomenda.setCliente(clienteService.findById(encomenda.getCliente().getId()));
        String mensagem = "A encomenda do cliente " + encomenda.getCliente().getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, encomenda, usuario);
    }

    @GetMapping("/encomenda/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Encomenda encomenda = encomendaService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            encomendaService.excluir(id);
            mensagem = "A encomenda do cliente " + encomenda.getCliente().getNome() + " foi excluída com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão da decoração " + encomenda.getCliente().getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, encomenda, usuarioUser);
    }
}
