package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Decoracao;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecoracaoRepository extends CrudRepository<Decoracao, Long> {
    @Query("from Decoracao a where a.usuario = :usuario order by a.nome")
    public List<Decoracao> obterLista(Usuario usuario);

    @Query("select count(d) from Decoracao d")
    public Integer obterQtd();

}
