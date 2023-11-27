package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Cliente;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obterLista(Usuario usuario) {
        return (List<Cliente>) clienteRepository.obterLista(usuario.getId());
    }
    public void incluir(Cliente cliente)  {clienteRepository.save(cliente);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public void editar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);

    }
    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Integer obterQtd(){
        return clienteRepository.obterQtd();
    }

}
