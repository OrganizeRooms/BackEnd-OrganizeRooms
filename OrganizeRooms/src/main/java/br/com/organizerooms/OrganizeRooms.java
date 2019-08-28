package br.com.organizerooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.organizerooms.enums.PerfilEnum;
import br.com.organizerooms.models.Ingrediente;
import br.com.organizerooms.models.Receita;
import br.com.organizerooms.models.Usuario;
import br.com.organizerooms.repositorios.IngrendienteRepository;
import br.com.organizerooms.repositorios.ReceitaRepository;
import br.com.organizerooms.repositorios.UsuarioRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrganizeRooms implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    IngrendienteRepository ingrendienteRepository;

    @Autowired
    ReceitaRepository receitaRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrganizeRooms.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Calendar calendar = Calendar.getInstance();
        Usuario user1;
        user1 = new Usuario(null,
                "admin",
                "admin@admin.com",
                "123",
                PerfilEnum.ROLE_ADMIN,
                "89080989089",
                "33531354",
                "8098098908908",
                "09313231222",
                "Silvar trac",
                12,
                "n tem",
                "centro",
                "Blumenau",
                "SC",
                "8915000");
        usuarioRepository.save(user1);
        Usuario user2;
        user2 = new Usuario(null,
                "usuario",
                "user@user.com",
                "123",
                PerfilEnum.ROLE_ADMIN,
                "89080989089",
                "33531354",
                "8098098908908",
                "09313231222",
                "Silvar trac",
                12,
                "n tem",
                "centro",
                "Blumenau",
                "SC",
                "8915000");
        usuarioRepository.save(user2);

        Ingrediente in1 = new Ingrediente("Morango", user1);
        Ingrediente in2 = new Ingrediente("Trigo", user1);
        Ingrediente in3 = new Ingrediente("ração", user1);
//        Ingrediente in4 = new Ingrediente("ddfd", user1);
//        Ingrediente in5 = new Ingrediente("Morawefwngo", user1);
//        Ingrediente in6 = new Ingrediente("Morwefwefngo", user1);
//        Ingrediente in7 = new Ingrediente("Morwefweango", user1);
//        Ingrediente in8 = new Ingrediente("Morwefwango", user1);
//        Ingrediente in9 = new Ingrediente("Mowfwerango", user1);
//        Ingrediente in10 = new Ingrediente("Morefango", user1);
//        Ingrediente in11 = new Ingrediente("Morefeango", user1);
//        Ingrediente in12 = new Ingrediente("Morfefango", user1);
//        Ingrediente in13 = new Ingrediente("Moraeffngo", user1);
//        Ingrediente in14 = new Ingrediente("Moraefengo", user1);
//        Ingrediente in15 = new Ingrediente("Moraefengo", user1);
//        Ingrediente in16 = new Ingrediente("Morfefango", user1);
//        Ingrediente in17 = new Ingrediente("Morfeango", user1);
//        Ingrediente in18 = new Ingrediente("Morfefango", user1);
//        Ingrediente in19 = new Ingrediente("Morfeefango", user1);
//        Ingrediente in20 = new Ingrediente("Morefeango", user1);
//        Ingrediente in21 = new Ingrediente("Morfefango", user1);
//        Ingrediente in22 = new Ingrediente("Moefefrango", user1);
//        Ingrediente in23 = new Ingrediente("Morfefango", user1);
//        Ingrediente in24 = new Ingrediente("Mofefeango", user1);
//        Ingrediente in25 = new Ingrediente("Morefefango", user1);
//        Ingrediente in26 = new Ingrediente("Morfeefango", user1);

        ingrendienteRepository.save(in1);
        ingrendienteRepository.save(in2);
        ingrendienteRepository.save(in3);
//        ingrendienteRepository.save(in4);
//        ingrendienteRepository.save(in5);
//        ingrendienteRepository.save(in6);
//        ingrendienteRepository.save(in7);
//        ingrendienteRepository.save(in8);
//        ingrendienteRepository.save(in9);
//        ingrendienteRepository.save(in10);
//        ingrendienteRepository.save(in11);
//        ingrendienteRepository.save(in12);
//        ingrendienteRepository.save(in13);
//        ingrendienteRepository.save(in14);
//        ingrendienteRepository.save(in15);
//        ingrendienteRepository.save(in16);
//        ingrendienteRepository.save(in17);
//        ingrendienteRepository.save(in18);
//        ingrendienteRepository.save(in19);
//        ingrendienteRepository.save(in20);
//        ingrendienteRepository.save(in21);
//        ingrendienteRepository.save(in22);
//        ingrendienteRepository.save(in23);
//        ingrendienteRepository.save(in24);
//        ingrendienteRepository.save(in25);
//        ingrendienteRepository.save(in25);

        List<Ingrediente> listaIngre = new ArrayList<>();
        listaIngre.add(in1);
        listaIngre.add(in2);

        List<Ingrediente> listaIngre2 = new ArrayList<>();
        listaIngre2.add(in3);
        listaIngre2.add(in2);
//        listaIngre.add(in5);
//        listaIngre.add(in6);
//        listaIngre.add(in16);
//        listaIngre.add(in15);
//        listaIngre.add(in17);
//        listaIngre.add(in19);
//        listaIngre.add(in4);
//        listaIngre.add(in20);

        Receita receita1 = new Receita("Bolo Trufado", "BLOOOOO11", 35.00, "https://www.nestleprofessional.com.br/sites/g/files/gfb331/f/styles/recipe/public/media/bolo-trufado-charge.jpg?itok=rgzHVFs1", listaIngre, user1, true);

        Receita receita2 = new Receita("Bolo Chocolate", "BLOOOOO11", 35.00, "https://vovopalmirinha.com.br/wp-content/uploads/2016/05/bolo-chocolate-simples-1.jpg", listaIngre2, user1, true);
        Receita receita3 = new Receita("Bolo Trufado 2", "BLOOOOO11", 35.00, "https://www.nestleprofessional.com.br/sites/g/files/gfb331/f/styles/recipe/public/media/bolo-trufado-charge.jpg?itok=rgzHVFs1", listaIngre, user2, true);

        Receita receita4 = new Receita("Bolo Chocolate 2", "BLOOOOO11", 35.00, "https://vovopalmirinha.com.br/wp-content/uploads/2016/05/bolo-chocolate-simples-1.jpg", listaIngre2, user2, true);

        receitaRepository.save(receita1);
        receitaRepository.save(receita2);
        receitaRepository.save(receita3);
        receitaRepository.save(receita4);
    }
}
