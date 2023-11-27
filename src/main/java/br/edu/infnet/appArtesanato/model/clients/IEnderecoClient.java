package br.edu.infnet.appArtesanato.model.clients;

import br.edu.infnet.appArtesanato.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoClient {
    @GetMapping(value = "/{cep}/json")
    public Endereco obterCep(@PathVariable String cep);

}
