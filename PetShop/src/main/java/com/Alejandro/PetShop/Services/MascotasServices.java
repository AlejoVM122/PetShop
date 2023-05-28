package com.Alejandro.PetShop.Services;

import com.Alejandro.PetShop.Entities.Mascota;
import com.Alejandro.PetShop.Entities.Usuario;
import com.Alejandro.PetShop.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MascotasServices {


    @Autowired
    private PetRepository repository;

    public Mascota  create (String name, String description,byte[] foto){
        Mascota pet1 = new Mascota();
        pet1.setName(name);
        pet1.setDescription(description);
        pet1.setFotos(foto);
        return pet1;
    }

    public List<Mascota> getList (){
        return repository.findAll();
    }

    public Mascota getMascota (Integer id){
        return repository.findById(id).orElseThrow(
                ()-> new ResponseStatusException
                        (HttpStatus.NO_CONTENT,"Su mascota no ha sido encontrada"));

    }

    public Mascota update (int id, String name, String description,byte[] foto){

        Mascota mascota = repository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        mascota.setName(name);
        mascota.setDescription(description);
        mascota.setFotos(foto);

        return repository.save(mascota);

    }


    public void  Delete (int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            System.out.println("Your pet has been deleted");
        }else {
            System.out.println("your pet hasn't been find");
        }




    }




}
