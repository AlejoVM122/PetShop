package com.Alejandro.PetShop.Config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//acordemonos que esto va a ser una dependencia que nos permite crear registros falsos
// para no tener que diligenciarlos todos

@Configuration
public class FakerBeanConfig {


    // este metodo lo que va a ser es que podamos usar el FAKER
    //TEN EN CUENTA SIEMPRE INDEXAR LAS DEPENDENCIES
    //ESTO ES UN BEAN EN EL CONTEXTO DE SPRING
    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
