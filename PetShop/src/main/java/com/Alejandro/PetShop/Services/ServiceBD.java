package com.Alejandro.PetShop.Services;

import com.Alejandro.PetShop.Entities.Usuario;
import com.Alejandro.PetShop.Repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


//recuerda que esta implementacion de esta interfaz se da en el contexto de Spring
//Por lo tanto, si tu quieres utilizarla la tienes que registrar en Spring
@Component
public class ServiceBD implements ApplicationRunner {

    //Mediante estos atributos vamos a usar el Faker y el
    //repositorio que esta conectado con la entidad de nuestra base de datos
    @Autowired
    private Faker faker;
    @Autowired
    private UserRepository repository;


    //esta interfaces, nos pide que implementemos 1 metodo, este es:
    //run y este se va a ejecutar cuando la aplicacion este iniciando

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {

            for (int i=0;i<200;i++){
                Usuario usuario = new Usuario();
                usuario.setUserName(faker.name().name());
                usuario.setPasword(faker.dragonBall().character());
                repository.save(usuario);
            }
            System.out.println("base de datos llena");

    }
     */

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
