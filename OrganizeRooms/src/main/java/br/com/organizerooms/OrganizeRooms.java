package br.com.organizerooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Unidade;
import br.com.organizerooms.repositorios.PessoaRepository;
import br.com.organizerooms.repositorios.UnidadeRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrganizeRooms implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UnidadeRepository unidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrganizeRooms.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //  Calendar calendar = Calendar.getInstance();
        Unidade unidade1 = new Unidade(null,
                "São Paulo",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade2 = new Unidade(null,
                "Rio de Janeiro",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade3 = new Unidade(null,
                "Blumenau",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade4 = new Unidade(null,
                "Apiuna",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade5 = new Unidade(null,
                "Florianópolis",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade6 = new Unidade(null,
                "Bahia",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade7 = new Unidade(null,
                "Lontras",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade8 = new Unidade(null,
                "Pomerode",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade9 = new Unidade(null,
                "Belo Horizonte",
                true,
                null,
                null,
                null,
                null);
        Unidade unidade10 = new Unidade(null,
                "Acre",
                true,
                null,
                null,
                null,
                null);

        unidadeRepository.save(unidade1);
        unidadeRepository.save(unidade2);
        unidadeRepository.save(unidade3);
        unidadeRepository.save(unidade4);
        unidadeRepository.save(unidade5);
        unidadeRepository.save(unidade6);
        unidadeRepository.save(unidade7);
        unidadeRepository.save(unidade8);
        unidadeRepository.save(unidade9);
        unidadeRepository.save(unidade10);
        

        Pessoa pes = new Pessoa(null,
                "ADIM",
                "admin@admin.com",
                "123",
                PerfilEnum.ROLE_ADMIN,
                unidade1,
                47,
                "992821333",
                "SIS",
                null,
                null,
                null,
                null);

        pessoaRepository.save(pes);

    }
}
