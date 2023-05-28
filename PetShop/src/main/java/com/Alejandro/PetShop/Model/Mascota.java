package com.Alejandro.PetShop.Model;

import java.util.Arrays;
import java.util.Objects;

public class Mascota {

    //Atributos

    private String name;

    //este es el atributo que me permitira colocarle  la foto de nuestra mascota
    private byte [] photo;

    //descripción de la mascota
    private String description;


    //Metodos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota mascota)) return false;
        return Objects.equals(getName(), mascota.getName()) && Arrays.equals(getPhoto(), mascota.getPhoto()) && Objects.equals(getDescription(), mascota.getDescription());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getDescription());
        result = 31 * result + Arrays.hashCode(getPhoto());
        return result;
    }
}
