package com.Alejandro.PetShop.Repository;


import com.Alejandro.PetShop.Entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Mascota,Integer> {

}
