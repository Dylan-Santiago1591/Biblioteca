package com.example.Libreria.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.example.Libreria.Models.Libro;

public interface ILibroService {
    
    public String save (Libro Libro);
    public List<Libro> findAll();
    public List<Libro> FiltrarTitulo(String Titulo);
    public List<Libro> FiltrarAutor(String Autor);
    public List<Libro> FiltrarGenero(String Genero);
    //FALTA FILTRAR POR ISBN
    public Optional<Libro> findOne(String id);
    public boolean delete(String id);
}
