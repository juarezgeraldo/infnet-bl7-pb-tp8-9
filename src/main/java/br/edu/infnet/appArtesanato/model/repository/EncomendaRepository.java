package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Cliente;
import br.edu.infnet.appArtesanato.model.domain.Encomenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncomendaRepository extends CrudRepository<Encomenda, Long> {
    @Query("from Encomenda a where a.usuario.id = :id order by a.cliente.nome")
    public List<Encomenda> obterLista(Long id);

    @Query("select count(e) from Encomenda e")
    public Integer obterQtd();

    @Query("select count(e) from Encomenda e where e.cliente = :cliente")
    public Integer qtdEncomendas(Cliente cliente);
}
