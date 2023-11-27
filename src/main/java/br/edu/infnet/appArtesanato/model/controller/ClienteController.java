package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Cliente;
import br.edu.infnet.appArtesanato.model.domain.Endereco;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.ClienteService;
import br.edu.infnet.appArtesanato.model.service.EncomendaService;
import br.edu.infnet.appArtesanato.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes({"oper", "cliente", "endereco"})
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EncomendaService encomendaService;

    @GetMapping("/cliente/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", clienteService.obterLista(usuario));
        return "/cliente/lista";
    }

    @GetMapping(value = "/cliente")
    public String telaCadastro(Model model) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        model.addAttribute("cliente", cliente);
        model.addAttribute("endereco", endereco);
        return "/cliente/cadastro";
    }

    @PostMapping(value = "/cliente/cep")
    public String obterCep(Model model,
                           @SessionAttribute("user") Usuario usuario,
                           @SessionAttribute("cliente") Cliente cliente,
                           @SessionAttribute("endereco") Endereco endereco,
                           @RequestParam String cep) {
        cliente.setEndereco(enderecoService.obterCep(cep));
        model.addAttribute("endereco", endereco);
        model.addAttribute("cliente", cliente);
        model.addAttribute("user", usuario);
        return "/cliente/cadastro";
    }

    @PostMapping("/cliente/incluir")
    public String incluir(Model model,
                          Cliente cliente,
                          Endereco endereco,
                          @SessionAttribute("user") Usuario usuario) {
        new Cliente(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
        cliente.setUsuario(usuario);
        cliente.setEndereco(endereco);
        clienteService.incluir(cliente);
        String mensagem = "O cliente " + cliente.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/cliente/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        String mensagem = null;
        String idMsg = null;
        if (!encomendaService.existEncomenda(cliente)) {
            try {
                clienteService.excluir(id);
                mensagem = "O cliente " + cliente.getNome() + " foi excluído com sucesso!!!";
                idMsg = "sucesso";
            } catch (Exception e) {
                mensagem = "Não foi possível realizar a exclusão do cliente " + cliente.getNome() + ". Erro retornado: " + e.getMessage();
                idMsg = "erro";
            }
        }else {
            mensagem = "Não foi possível realizar a exclusão do cliente " + cliente.getNome() + ". Há encomendas associadas a ele. ";
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
