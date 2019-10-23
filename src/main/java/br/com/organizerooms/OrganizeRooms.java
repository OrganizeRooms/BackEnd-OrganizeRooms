package br.com.organizerooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.models.Equipamento;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Unidade;
import br.com.organizerooms.repositorios.EquipamentoRepository;
import br.com.organizerooms.repositorios.PessoaRepository;
import br.com.organizerooms.repositorios.SalaRepository;
import br.com.organizerooms.repositorios.UnidadeRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrganizeRooms implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UnidadeRepository unidadeRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    SalaRepository salaRepository;

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
        unidadeRepository.save(unidade1);

        Pessoa pes = new Pessoa(null,
                "ADIM",
                "admin@admin.com",
                "123",
                PerfilEnum.ROLE_ADMIN,
                unidade1,
                "47",
                "992821333",
                "SIS",
                null,
                null,
                null,
                null);
        pessoaRepository.save(pes);

        Optional<Unidade> optUni = unidadeRepository.findById(1L);
        Unidade uni = optUni.get();
        unidade1 = new Unidade(uni.getUniId(),
                uni.getUniNome(),
                uni.getUniAtiva(),
                uni.getUniDtCadastro(),
                pes,
                uni.getUniDtAtualizacao(),
                pes);
        unidadeRepository.save(unidade1);

        Unidade unidade2 = new Unidade(null,
                "Rio de Janeiro",
                true,
                null,
                pes,
                null,
                pes);
        Unidade unidade3 = new Unidade(null,
                "Blumenau",
                true,
                null,
                pes,
                null,
                pes);
        Unidade unidade4 = new Unidade(null,
                "Apiuna",
                false,
                null,
                pes,
                null,
                pes);
        Unidade unidade5 = new Unidade(null,
                "Florianópolis",
                false,
                null,
                pes,
                null,
                pes);
        Unidade unidade6 = new Unidade(null,
                "Bahia",
                true,
                null,
                pes,
                null,
                pes);
        Unidade unidade7 = new Unidade(null,
                "Lontras",
                false,
                null,
                pes,
                null,
                pes);
        Unidade unidade8 = new Unidade(null,
                "Pomerode",
                true,
                null,
                pes,
                null,
                pes);
        Unidade unidade9 = new Unidade(null,
                "Belo Horizonte",
                false,
                null,
                pes,
                null,
                pes);
        Unidade unidade10 = new Unidade(null,
                "Acre",
                true,
                null,
                pes,
                null,
                pes);

        unidadeRepository.save(unidade2);
        unidadeRepository.save(unidade3);
        unidadeRepository.save(unidade4);
        unidadeRepository.save(unidade5);
        unidadeRepository.save(unidade6);
        unidadeRepository.save(unidade7);
        unidadeRepository.save(unidade8);
        unidadeRepository.save(unidade9);
        unidadeRepository.save(unidade10);

        Equipamento equipamento1 = new Equipamento(
                null,
                "Notebook Acer",
                "Notebook Acer Core i3 8 geração",
                unidade1,
                false,
                pes,
                null,
                null,
                pes);

        Equipamento equipamento2 = new Equipamento(
                null,
                "Notebook Dell",
                "Notebook Dell Core i5 8 geração",
                unidade2,
                true,
                pes,
                null,
                null,
                pes);

        Equipamento equipamento3 = new Equipamento(
                null,
                "Notebook Positivo",
                "Notebook Positivo Pentium",
                unidade3,
                false,
                pes,
                null,
                null,
                pes);

        Equipamento equipamento4 = new Equipamento(
                null,
                "Notebook Phillips",
                "Notebook Phillips Core i10 12 geração",
                unidade4,
                true,
                pes,
                null,
                null,
                pes);

        equipamentoRepository.save(equipamento1);
        equipamentoRepository.save(equipamento2);
        equipamentoRepository.save(equipamento3);
        equipamentoRepository.save(equipamento4);

        Sala sala1 = new Sala(
                null,
                "Sala Comercial 02",
                10,
                true,
                pes,
                null,
                null,
                pes,
                unidade4);

        Sala sala2 = new Sala(
                null,
                "Sala Comercial 01",
                8,
                false,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala3 = new Sala(
                null,
                "Sala de Guerra",
                22,
                true,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala4 = new Sala(
                null,
                "Sala de Reuniões Kanban 03",
                10,
                false,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala5 = new Sala(
                null,
                "Sala de Reuniões Kanban 06",
                12,
                false,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala6 = new Sala(
                null,
                "Sala de Reuniões Kanban 01",
                12,
                true,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala7 = new Sala(
                null,
                "Sala Reunião Stakeholders",
                5,
                true,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala8 = new Sala(
                null,
                "Sala Livre 02",
                4,
                true,
                pes,
                null,
                null,
                pes,
                unidade4);
        Sala sala9 = new Sala(
                null,
                "Sala Livre 01",
                4,
                true,
                pes,
                null,
                null,
                pes,
                unidade5);
        Sala sala10 = new Sala(
                null,
                "Sala Livre 03",
                4,
                false,
                pes,
                null,
                null,
                pes,
                unidade2);

        salaRepository.save(sala1);
        salaRepository.save(sala2);
        salaRepository.save(sala3);
        salaRepository.save(sala4);
        salaRepository.save(sala5);
        salaRepository.save(sala6);
        salaRepository.save(sala7);
        salaRepository.save(sala8);
        salaRepository.save(sala9);
        salaRepository.save(sala10);

    }
}
