package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Artesanato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtesanatoRepository extends CrudRepository<Artesanato, Long> {
    @Query("from Artesanato a where a.usuario.id = :id order by a.nome")
    public List<Artesanato> obterLista(Long id);

    @Query("select count(a) from Artesanato a")
    public Integer obterQtd();

}
