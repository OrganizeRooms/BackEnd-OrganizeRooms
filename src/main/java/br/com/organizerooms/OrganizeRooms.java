package br.com.organizerooms;

import br.com.organizerooms.dto.AgendamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.models.Agendamento;
import br.com.organizerooms.models.Equipamento;
import br.com.organizerooms.models.Notificacao;
import br.com.organizerooms.models.Participante;
import br.com.organizerooms.models.Pessoa;
import br.com.organizerooms.models.Sala;
import br.com.organizerooms.models.Unidade;
import br.com.organizerooms.repositorios.AgendamentoRepository;
import br.com.organizerooms.repositorios.EquipamentoRepository;
import br.com.organizerooms.repositorios.NotificacaoRepository;
import br.com.organizerooms.repositorios.ParticipanteRepository;
import br.com.organizerooms.repositorios.PessoaRepository;
import br.com.organizerooms.repositorios.SalaRepository;
import br.com.organizerooms.repositorios.UnidadeRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
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

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    @Autowired
    NotificacaoRepository notificacaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrganizeRooms.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

        Unidade unidade1 = new Unidade(null,
                "São Paulo",
                true,
                calendar.getTime(),
                null,
                calendar.getTime(),
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
                calendar.getTime(),
                null,
                calendar.getTime());
        pessoaRepository.save(pes);

        Pessoa pes2 = new Pessoa(null,
                "Lucas Jansen",
                "lucasrainoldojansen@gmail.com",
                "123",
                PerfilEnum.ROLE_USUARIO,
                unidade1,
                "47",
                "992821333",
                "SIS",
                null,
                calendar.getTime(),
                null,
                calendar.getTime());
        pessoaRepository.save(pes2);

        Optional<Unidade> optUni = unidadeRepository.findById(1L);
        Unidade uni = optUni.get();
        unidade1 = new Unidade(uni.getUniId(),
                uni.getUniNome(),
                uni.getUniAtiva(),
                uni.getUniDtCadastro(),
                pes.getPesId(),
                uni.getUniDtAtualizacao(),
                pes.getPesId());
        unidadeRepository.save(unidade1);

        Unidade unidade2 = new Unidade(null,
                "Rio de Janeiro",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade3 = new Unidade(null,
                "Blumenau",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade4 = new Unidade(null,
                "Apiuna",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade5 = new Unidade(null,
                "Florianópolis",
                false,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade6 = new Unidade(null,
                "Bahia",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade7 = new Unidade(null,
                "Lontras",
                false,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade8 = new Unidade(null,
                "Pomerode",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade9 = new Unidade(null,
                "Belo Horizonte",
                false,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());
        Unidade unidade10 = new Unidade(null,
                "Acre",
                true,
                calendar.getTime(),
                pes.getPesId(),
                calendar.getTime(),
                pes.getPesId());

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
                unidade4,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId());

        Equipamento equipamento2 = new Equipamento(
                null,
                "Notebook Dell",
                "Notebook Dell Core i5 8 geração",
                unidade2,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId());

        Equipamento equipamento3 = new Equipamento(
                null,
                "Notebook Positivo",
                "Notebook Positivo Pentium",
                unidade3,
                false,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId());

        Equipamento equipamento4 = new Equipamento(
                null,
                "Notebook Phillips",
                "Notebook Phillips Core i10 12 geração",
                unidade4,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId());

        equipamentoRepository.save(equipamento1);
        equipamentoRepository.save(equipamento2);
        equipamentoRepository.save(equipamento3);
        equipamentoRepository.save(equipamento4);

        Sala sala1 = new Sala(
                null,
                "Sala Comercial 02",
                10,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);

        Sala sala2 = new Sala(
                null,
                "Sala Comercial 01",
                8,
                false,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala3 = new Sala(
                null,
                "Sala de Guerra",
                22,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala4 = new Sala(
                null,
                "Sala de Reuniões Kanban 03",
                10,
                false,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala5 = new Sala(
                null,
                "Sala de Reuniões Kanban 06",
                12,
                false,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala6 = new Sala(
                null,
                "Sala de Reuniões Kanban 01",
                12,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala7 = new Sala(
                null,
                "Sala Reunião Stakeholders",
                5,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala8 = new Sala(
                null,
                "Sala Livre 02",
                4,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade4);
        Sala sala9 = new Sala(
                null,
                "Sala Livre 01",
                4,
                true,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
                unidade5);
        Sala sala10 = new Sala(
                null,
                "Sala Livre 03",
                4,
                false,
                pes.getPesId(),
                calendar.getTime(),
                calendar.getTime(),
                pes.getPesId(),
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

        Date ageData = new Date("2019/11/06");

        Date ageHoraInicio1 = new Date("2019/11/06 14:00:00");
        Date ageHoraFim1 = new Date("2019/11/06 15:00:00");

        List<Equipamento> equips1 = new ArrayList<>();
        equips1.add(equipamento1);

        Agendamento age = new Agendamento(
                null,
                "Reunião do Kanban com Equipe de Desenvolvimento",
                "Reunião do Kanban com Equipe de Desenvolvimento",
                "AGENDADO",
                ageData,
                ageHoraInicio1,
                ageHoraFim1,
                calendar.getTime(),
                calendar.getTime(),
                sala6,
                pes,
                1l,
                1l,
                equips1,
                null);

        //Date ageHoraInicio2 = new Date(2019, 10, 10, 15, 00);
        //Date ageHoraFim2 = new Date(2019, 10, 10, 16, 00);
        List<Equipamento> equips2 = new ArrayList<>();
        equips2.add(equipamento2);

        Agendamento age2 = new Agendamento(
                null,
                "Reunião do Kanban com Equipe de Desenvolvimento 02",
                "Reunião do Kanban com Equipe de Desenvolvimento 02",
                "AGENDADO",
                ageData,
                ageHoraInicio1,
                ageHoraFim1,
                calendar.getTime(),
                calendar.getTime(),
                sala7,
                pes2,
                1l,
                1l,
                equips2,
                null);
        Agendamento ageGravado = agendamentoRepository.save(age);
        Agendamento ageGravado2 = agendamentoRepository.save(age2);

        /// PRIMEIRO
        Participante part1Age1 = new Participante(null, 1, null, pes2, ageGravado);
        Participante part2Age1 = new Participante(null, 1, null, pes, ageGravado);

        List<Participante> parts1 = new ArrayList<>();
        parts1.add(part1Age1);
        parts1.add(part2Age1);

        /// SEGUNDO
        Participante part1Age2 = new Participante(null, 1, null, pes2, ageGravado2);
        Participante part2Age2 = new Participante(null, 1, null, pes, ageGravado2);
 
        List<Participante> parts2 = new ArrayList<>();
        parts2.add(part1Age2);
        parts2.add(part2Age2);

        participanteRepository.save(part1Age1);
        participanteRepository.save(part2Age1);

        participanteRepository.save(part1Age2);
        participanteRepository.save(part2Age2);

        /*Notificacao noti1 = new Notificacao(
         null,
         "Você possui um novo Agendamento Marcado",
         true,
         calendar.getTime(),
         calendar.getTime(),
         1l,
         1l,
         true,
         pes);

         Notificacao noti2 = new Notificacao(
         null,
         "Você possui um novo Agendamento Marcado 02",
         true,
         calendar.getTime(),
         calendar.getTime(),
         1l,
         1l,
         true,
         pes);

         Notificacao noti3 = new Notificacao(
         null,
         "Você possui um novo Agendamento Marcado 03",
         true,
         calendar.getTime(),
         calendar.getTime(),
         1l,
         1l,
         true,
         pes);

         Notificacao noti4 = new Notificacao(
         null,
         "Você possui um novo Agendamento Marcado 04",
         true,
         calendar.getTime(),
         calendar.getTime(),
         1l,
         1l,
         true,
         pes);

         Notificacao noti5 = new Notificacao(
         null,
         "Você possui um novo Agendamento Marcado 04",
         true,
         calendar.getTime(),
         calendar.getTime(),
         1l,
         1l,
         true,
         pes);

         notificacaoRepository.save(noti1);
         notificacaoRepository.save(noti2);
         notificacaoRepository.save(noti3);
         notificacaoRepository.save(noti4);
         notificacaoRepository.save(noti5);*/
    }
}
