package com.Alejandro.PetShop.Controller;

import com.Alejandro.PetShop.Entities.Usuario;
import com.Alejandro.PetShop.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private UsuarioServices services;

    //metodos Http

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<>(services.getList(),HttpStatus.OK);
    }

    //Aca vamos a construir el Get Mapping por ID

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id){
        return  new ResponseEntity<>(services.GetUser(id),HttpStatus.OK);
    }


    @PostMapping
    private ResponseEntity<Usuario> createUsuario (@RequestBody Usuario usuario){
        return new ResponseEntity<>(services.create(usuario),HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    private ResponseEntity<Usuario> update (@PathVariable int id,@RequestBody Usuario usuario){
        return new ResponseEntity<>(services.update(id,usuario.getUserName(), usuario.getPasword()),HttpStatus.OK);

    }

    //Debemos tener en cuenta que vamos a hacer un objeto del tipo ResponseEntity
    //pero este no tiene que devolver nada en concreto
    //la pathVariable va a estar en la ruta de la URl del programa
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUsuariobyId (@PathVariable int id){
        services.delete(id);
        return new  ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
