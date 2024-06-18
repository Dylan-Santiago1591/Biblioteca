package com.example.Libreria.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Libreria.Models.Usuario;



@Repository
public interface IUsuario extends CrudRepository<Usuario, String> {

    @Query("SELECT U FROM Usuario U WHERE U.Nombre LIKE %?1%")
    List<Usuario> FiltrarNombre(String Nombre);

    @Query("SELECT U FROM Usuario U WHERE U.Apellido LIKE %?1%")
    List<Usuario> FiltrarApellido(String Apellido);

    @Query("SELECT U FROM Usuario U WHERE U.CorreoElectronico LIKE %?1%")
    List<Usuario> FiltrarCorreoElectronico(String CorreoElectronico);
}
