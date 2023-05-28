package com.Alejandro.PetShop.Repository;

import com.Alejandro.PetShop.Entities.Usuario;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




//Recordemos que esto debe ser siempre una interface
@Repository
public interface UserRepository extends JpaRepository<Usuario,Integer> {


}
