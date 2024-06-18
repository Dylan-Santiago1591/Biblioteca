package com.example.Libreria.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Libreria.InterfaceService.ILibroService;
import com.example.Libreria.Interfaces.ILibro;
import com.example.Libreria.Models.Libro;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private ILibro data;

    @Override
    public String save(Libro Libro) {
        data.save(Libro);
        return Libro.getIdLibro();
    }

    @Override
    public List<Libro> findAll() {
        List<Libro> ListaLibro = (List<Libro>) data.findAll();
        return ListaLibro;
    }

    @Override
    public List<Libro> FiltrarTitulo(String Titulo) {
        List<Libro> ListaLibro = data.FiltrarTitulo(Titulo);
        return ListaLibro;
    }

    @Override
    public List<Libro> FiltrarAutor(String Autor) {
        List<Libro> ListaLibro = data.FiltrarAutor(Autor);
        return ListaLibro;
    }

    @Override
    public List<Libro> FiltrarGenero(String Genero) {
        List<Libro> ListaLibro = data.FiltrarGenero(Genero);
        // DATA: ES UN REPOSITORIO QUE SE CREA CON LA EXTENSION
        // SPRINT DATA JPA
        return ListaLibro;
    }
    // FALTA EL PUBLIC POR ISBN

    // ESTE BLOQUE ES FILTAR POR ID
    // @Override
    // public Optional<Libro> findOne(String IdLibro){
    // Optional<Libro> Libro = data.findById(IdLibro);
    // return Libro;
    // }

    // @Override
    // public int delete(String id) {
    //     data.deleteById(id);
    //     return 1;
    // }

    @Override
    public Optional<Libro> findOne(String id) {
        Optional<Libro> Libro=data.findById(id);
        return Libro;
    }


    @Override
    public boolean delete(String id) {
        if (data.existsById(id)) {
            data.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
