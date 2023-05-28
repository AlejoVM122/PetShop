package com.Alejandro.PetShop.Entities;

import jakarta.persistence.*;


//esta clase va a ser otra entidad que tenemos en nuestro modelo que nos va a
// permitir guardar las mascotas que creemos


//en el contexto de java y con la dependencia que agregamos  la debemos colocar
@Entity
@Table(name="mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name="imegen")
    private String imagen;
    @Lob
    @Column(name = "Fotos")
    public byte fotos[];

   @OneToOne
   @JoinColumn(name ="usuario_id",referencedColumnName = "ID")
   private Usuario usuario;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

