package com.clinica.veterinaria.runner;

import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.model.Propietario;
import com.clinica.veterinaria.repository.MascotaRepository;
import com.clinica.veterinaria.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PropietarioRepository propietarioRepo;

    @Autowired
    private MascotaRepository mascotaRepo;

    @Override
    public void run(String... args) throws Exception {

        if (propietarioRepo.count() == 0) {

            Propietario p1 = propietarioRepo.save(new Propietario("Carlos", "Garcia Lopez", "600111222", "carlos@gmail.com", "Calle Mayor 1"));
            Propietario p2 = propietarioRepo.save(new Propietario("Maria", "Martinez Ruiz", "600222333", "maria@gmail.com", "Calle Luna 5"));
            Propietario p3 = propietarioRepo.save(new Propietario("Juan", "Lopez Sanchez", "600333444", "juan@gmail.com", "Avenida Sol 10"));
            Propietario p4 = propietarioRepo.save(new Propietario("Ana", "Fernandez Gil", "600444555", "ana@gmail.com", "Calle Rosa 3"));
            Propietario p5 = propietarioRepo.save(new Propietario("Pedro", "Gomez Torres", "600555666", "pedro@gmail.com", "Calle Pino 7"));
            Propietario p6 = propietarioRepo.save(new Propietario("Laura", "Diaz Moreno", "600666777", "laura@gmail.com", "Avenida Mar 15"));
            Propietario p7 = propietarioRepo.save(new Propietario("Luis", "Hernandez Vega", "600777888", "luis@gmail.com", "Calle Olivo 9"));
            Propietario p8 = propietarioRepo.save(new Propietario("Elena", "Jimenez Reyes", "600888999", "elena@gmail.com", "Calle Cedro 2"));
            Propietario p9 = propietarioRepo.save(new Propietario("Miguel", "Ruiz Navarro", "600999000", "miguel@gmail.com", "Avenida Rio 20"));
            Propietario p10 = propietarioRepo.save(new Propietario("Sofia", "Moreno Castro", "601000111", "sofia@gmail.com", "Calle Roble 4"));

            mascotaRepo.save(new Mascota("Rex", "Perro", "Pastor Aleman", LocalDate.of(2019, 3, 15), 30.5, p1));
            mascotaRepo.save(new Mascota("Luna", "Gato", "Siames", LocalDate.of(2020, 7, 22), 4.2, p2));
            mascotaRepo.save(new Mascota("Max", "Perro", "Labrador", LocalDate.of(2018, 11, 5), 28.0, p3));
            mascotaRepo.save(new Mascota("Mia", "Gato", "Persa", LocalDate.of(2021, 2, 10), 3.8, p4));
            mascotaRepo.save(new Mascota("Rocky", "Perro", "Bulldog", LocalDate.of(2017, 6, 30), 22.0, p5));
            mascotaRepo.save(new Mascota("Cleo", "Conejo", "Belier", LocalDate.of(2022, 1, 18), 2.5, p6));
            mascotaRepo.save(new Mascota("Toby", "Perro", "Beagle", LocalDate.of(2020, 9, 14), 12.3, p7));
            mascotaRepo.save(new Mascota("Nala", "Gato", "Maine Coon", LocalDate.of(2019, 5, 25), 5.1, p8));
            mascotaRepo.save(new Mascota("Simba", "Perro", "Golden Retriever", LocalDate.of(2021, 8, 3), 32.0, p9));
            mascotaRepo.save(new Mascota("Pica", "Pajaro", "Canario", LocalDate.of(2022, 4, 12), 0.3, p10));
        }
    }
}