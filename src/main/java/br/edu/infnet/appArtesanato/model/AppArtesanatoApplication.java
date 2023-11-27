package br.edu.infnet.appArtesanato.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("br.edu.infnet.appArtesanato.model.repository")
public class AppArtesanatoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppArtesanatoApplication.class, args);
    }
}
