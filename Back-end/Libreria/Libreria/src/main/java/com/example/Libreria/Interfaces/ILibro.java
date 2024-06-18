package com.example.Libreria.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Libreria.Models.Libro;

@Repository
public interface ILibro extends CrudRepository<Libro, String> {
    @Query("SELECT L FROM Libro L WHERE L.Titulo LIKE %?1%")
    List<Libro> FiltrarTitulo(String Titulo);
    
    @Query("SELECT L FROM Libro L WHERE L.Autor LIKE %?1%")
    List<Libro> FiltrarAutor(String Autor);

    @Query("SELECT L FROM Libro L WHERE L.Genero LIKE %?1%")
    List<Libro> FiltrarGenero(String Genero);

    //QUEDA FALTANDO EL FILTAR POR ISBN
}
