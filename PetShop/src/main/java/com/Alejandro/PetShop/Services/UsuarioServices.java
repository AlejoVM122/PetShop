package com.Alejandro.PetShop.Services;

import com.Alejandro.PetShop.Entities.Usuario;
import com.Alejandro.PetShop.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServices {


    //Acá está la inyección del repositorio a esta clase
    @Autowired
    private UserRepository repository;


    //los servicios que tiene esta clase

    //create
    public Usuario createUsuario (String account, String pasword){
        Usuario usuario = new Usuario();
        usuario.setUserName(account);
        usuario.setPasword(pasword);
        return repository.save(usuario);}

    //traer toda la lista
    public List<Usuario> getList (){
        return repository.findAll();
    }


    public Usuario create (Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario GetUser (Integer id){
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NO_CONTENT,"No se encontro el valor asociado al %s "));

    }



    //eliminar
    public void delete (int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            System.out.println("Your username has been deleted");
        } else{
            System.out.println("No se encontro el usuario");
        }
    }

    //modificar
    public Usuario update (int id, String username, String password){

        //en este metodo buscamos el usuario con lamdas y le mandamos el error sino lo encuentra
        /*
        Guardamos el usuario en uno nuevo
        establecemos los nuevos valores y traemos el usuario guardado
         */
        Usuario usuarioExistente = repository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
                usuarioExistente.setUserName(username);
                usuarioExistente.setPasword(password);

                return repository.save(usuarioExistente);

    }

}




