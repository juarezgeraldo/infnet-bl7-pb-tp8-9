package br.edu.infnet.appArtesanato.model.repository;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select count(c) from Cliente c where c.usuario.id = :id ")
    public Integer obterQtdClientes(Long id);

    @Query("select count(e) from Encomenda e where e.usuario.id = :id ")
    public Integer obterQtdEncomendas(Long id);

    @Query("select count(a) from Artesanato a where a.usuario.id = :id ")
    public Integer obterQtdArtesanatos(Long id);

    @Query("from Usuario u where u.email = :email and u.senha = :senha")
    public Usuario autenticacao(String email, String senha);

    @Query("from Usuario u order by u.nome")
    public List<Usuario> obterLista();

    boolean existsByEmail(String email);

    @Query("from Usuario u where u.id = :id")
    public Usuario findBy(Long id);

    @Query("select count(u) from Usuario u")
    public Integer obterQtd();

}
