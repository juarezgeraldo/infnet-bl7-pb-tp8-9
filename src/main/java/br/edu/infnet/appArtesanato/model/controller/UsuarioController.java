package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.dto.UsuarioDTO;
import br.edu.infnet.appArtesanato.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario/cadastro/inicio")
    public String telaCadastroinicio(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "/usuario/cadastro";
    }

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuarioUser) {
        model.addAttribute("user", usuarioUser);
        return "/usuario/cadastro";
    }

    @GetMapping("/usuario/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuarioUser, Usuario usuario) {
        List<UsuarioDTO> usuarioList = usuarioService.obterLista();
        model.addAttribute("lista", usuarioList);
        model.addAttribute("user", usuarioUser);
        return "/usuario/lista";
    }

    @PostMapping(value = "/usuario/incl")
    public String incluir(Model model, Usuario usuario) {
        if (!usuarioService.verficaUsuarioExistente(usuario)) {
            usuarioService.incluir(usuario);
            String mensagem = "O usuário " + usuario.getNome() + " foi cadastrado com sucesso!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "sucesso";
            model.addAttribute("idMsg", idMsg);
            return "redirect:/";
        } else {
            String mensagem = "Já existe o e-mail " + usuario.getEmail() + " registrado para outro usuário.";
            model.addAttribute("msg", mensagem);
            String idMsg = "erro";
            model.addAttribute("idMsg", idMsg);
        }
        model.addAttribute("usuario", usuario);
        return telaCadastroinicio(model, usuario);
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Model model, @SessionAttribute("user") Usuario usuarioUser, Usuario usuario) {
        if (!usuarioService.verficaUsuarioExistente(usuario)) {
            usuarioService.incluir(usuario);
            String mensagem = "O usuário " + usuario.getNome() + " foi cadastrado com sucesso!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "sucesso";
            model.addAttribute("idMsg", idMsg);
            model.addAttribute("usuario", usuario);
            return telaLista(model, usuarioUser, usuario);
        } else {
            String mensagem = "Já existe o e-mail " + usuario.getEmail() + " registrado para outro usuário.";
            model.addAttribute("msg", mensagem);
            String idMsg = "erro";
            model.addAttribute("idMsg", idMsg);
        }
        return telaCadastro(model, usuarioUser);
    }

    @GetMapping("/usuario/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuarioUser.getId() != id) {
            usuarioService.excluir(id);
            String mensagem = "O usuário " + usuario.getNome() + " foi excluído com sucesso!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "sucesso";
            model.addAttribute("idMsg", idMsg);
        } else {
            String mensagem = "O próprio usuário " + usuario.getNome() + " NÃO pode se excluir!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "erro";
            model.addAttribute("idMsg", idMsg);
        }
        return telaLista(model, usuarioUser, null);
    }

}
