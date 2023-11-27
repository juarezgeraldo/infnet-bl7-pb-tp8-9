package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Artesanato;
import br.edu.infnet.appArtesanato.model.repository.ArtesanatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ArtesanatoService {
    @Autowired
    private ArtesanatoRepository artesanatoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Artesanato> obterLista(Long id) {
        return (List<Artesanato>) artesanatoRepository.obterLista(id);
    }

    public void incluir(Artesanato artesanato) {
        artesanatoRepository.save(artesanato);
    }

    public void excluir(Long id) {
        artesanatoRepository.deleteById(id);
    }

    public Artesanato findById(Long id){
        return artesanatoRepository.findById(id).orElse(null);
    }

    public List<Artesanato> findAll(){
        return (List<Artesanato>) artesanatoRepository.findAll();
    }

    public Integer obterQtd(){
        return artesanatoRepository.obterQtd();
    }

}
