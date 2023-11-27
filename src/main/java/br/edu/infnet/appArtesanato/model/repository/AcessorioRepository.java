package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessorioRepository extends CrudRepository<Acessorio, Long> {
    @Query("from Acessorio a where a.usuario = :usuario order by a.nome")
    public List<Acessorio> obterLista(Usuario usuario);

    @Query("select count(a) from Acessorio a")
    public Integer obterQtd();

}
