package com.Alejandro.PetShop.Controller;

import com.Alejandro.PetShop.Entities.Mascota;
import com.Alejandro.PetShop.Repository.PetRepository;
import com.Alejandro.PetShop.Services.MascotasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/Pet")
public class PetController {


    @Autowired
    private MascotasServices services;

    @Autowired
    private PetRepository repository;


    @PostMapping("/mascota")
    public void crearImgen (@RequestParam("file") MultipartFile multi,@RequestBody String description) throws IOException {
        try{
            Mascota mascota1 = new Mascota();
            mascota1.setName(multi.getOriginalFilename());
            mascota1.setFotos(multi.getBytes());
            mascota1.setDescription(description);

            repository.save(mascota1);
            System.out.println("Mascota creada exitosamente");

        }catch (IOException e){
            e.getMessage();
        }
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Optional<Mascota> result = repository.findById(id);
        if (result.isPresent()) {
            Mascota image = result.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(image.getFotos().length);
            return new ResponseEntity<>(image.getFotos(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
