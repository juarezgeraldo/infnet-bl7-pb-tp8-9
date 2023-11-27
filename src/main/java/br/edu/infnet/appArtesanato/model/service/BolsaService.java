package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.repository.BolsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolsaService {

    @Autowired
    private BolsaRepository bolsaRepository;

    public List<Bolsa> obterLista(Usuario usuario) {
        return (List<Bolsa>) bolsaRepository.obterLista(usuario);
    }

    public void incluir(Bolsa bolsa)  {bolsaRepository.save(bolsa);
    }

    public Bolsa findById(Long id){
        return bolsaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        bolsaRepository.deleteById(id);
    }
    public List<Bolsa> findAll(){
        return (List<Bolsa>) bolsaRepository.findAll();
    }

    public Integer obterQtd(){
        return bolsaRepository.obterQtd();
    }

}
