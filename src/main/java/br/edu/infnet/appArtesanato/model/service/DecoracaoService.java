package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Decoracao;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.repository.DecoracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecoracaoService {

    @Autowired
    private DecoracaoRepository decoracaoRepository;

    public List<Decoracao> obterLista(Usuario usuario) {
        return (List<Decoracao>) decoracaoRepository.obterLista(usuario);
    }

    public Decoracao findById(Long id){
        return decoracaoRepository.findById(id).orElse(null);
    }

    public void incluir(Decoracao decoracao) {
        decoracaoRepository.save(decoracao);
    }

    public void excluir(Long id) {
        decoracaoRepository.deleteById(id);
    }
    public List<Decoracao> findAll(){
        return (List<Decoracao>) decoracaoRepository.findAll();
    }

    public Integer obterQtd(){
        return decoracaoRepository.obterQtd();
    }

}
