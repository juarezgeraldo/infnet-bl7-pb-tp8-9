package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Bolsa;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolsaRepository extends CrudRepository<Bolsa, Long> {
    @Query("from Bolsa a where a.usuario = :usuario order by a.nome")
    public List<Bolsa> obterLista(Usuario usuario);

    @Query("select count(b) from Bolsa b")
    public Integer obterQtd();

}
