package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Cliente;
import br.edu.infnet.appArtesanato.model.domain.Encomenda;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository encomendaRepository;

    public List<Encomenda> obterLista(Usuario usuario) {
        return (List<Encomenda>) encomendaRepository.obterLista(usuario.getId());
    }
    public List<Encomenda> findAll() {
        return (List<Encomenda>) encomendaRepository.findAll();
    }

    public void incluir(Encomenda encomenda)  {encomendaRepository.save(encomenda);
    }

    public void excluir(Long id) {
        encomendaRepository.deleteById(id);
    }

    public void editar(Encomenda encomenda) {
        encomendaRepository.save(encomenda);
    }

    public Encomenda findById(Long id) {
        return encomendaRepository.findById(id).orElse(null);
    }

    public boolean existEncomenda(Cliente cliente) {
        return encomendaRepository.qtdEncomendas(cliente) > 0;
    }

    public Integer obterQtd(){
        return encomendaRepository.obterQtd();
    }

}
