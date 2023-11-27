package br.edu.infnet.appArtesanato.model.service;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.dto.UsuarioDTO;
import br.edu.infnet.appArtesanato.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obterLista() {
        List<Usuario> usuarioList = (List<Usuario>) usuarioRepository.obterLista();
        List<UsuarioDTO> usuarioDTOList =  new ArrayList<>();

        for (Usuario usuario : usuarioList) {

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setAdmin(usuario.isAdmin());
            usuarioDTO.setQtClientes(usuarioRepository.obterQtdClientes(usuario.getId()));
            usuarioDTO.setQtEncomendas(usuarioRepository.obterQtdEncomendas(usuario.getId()));
            usuarioDTO.setQtArtesanatos(usuarioRepository.obterQtdArtesanatos(usuario.getId()));
            usuarioDTOList.add(usuarioDTO);

        }
        return usuarioDTOList;
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario validar(String email, String senha) {
        return usuarioRepository.autenticacao(email, senha);
    }

    public boolean verficaUsuarioExistente(Usuario usuario)  {
        return usuarioRepository.existsByEmail(usuario.getEmail());
    }

    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioRepository.obterLista();
    }

    public Integer obterQtd(){
        return usuarioRepository.obterQtd();
    }

}
