package br.edu.infnet.appArtesanato.model;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = new Usuario();

        usuario.setNome("Juarez Geraldo Silva Junior");
        usuario.setEmail("juarez.junior@al.infnet.edu.br");
        usuario.setSenha("123");
        usuario.setAdmin(true);

        usuarioService.incluir(usuario);

        System.out.println("Inclusão de usuário realizada!!!");

    }
}
