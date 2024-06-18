package com.example.Libreria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.Libreria.InterfaceService.ILibroService;
import com.example.Libreria.Models.Libro;


@RequestMapping("/api/v1/Libro/")
@RestController
public class LibroController {

    @Autowired
    private ILibroService LibroService;

    //AÑADIR CAMPOS OBLIGATORIOS
    @PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("Libro") Libro Libro){
        if (Libro.getTitulo().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Libro.getAutor().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Libro.getGenero().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }

        LibroService.save(Libro);
        return new ResponseEntity<>(Libro, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var ListaLibro = LibroService.findAll();
        return new ResponseEntity<>(ListaLibro, HttpStatus.OK);
    }

    @GetMapping("FiltrarTitulo/{Titulo}")
    public ResponseEntity<Object> findTitulo(@PathVariable String Titulo){
        var ListaLibro = LibroService.FiltrarTitulo(Titulo);
        return new ResponseEntity<>(ListaLibro, HttpStatus.OK);
    }
    
    @GetMapping("FiltrarAutor/{Autor}")
    public ResponseEntity<Object> findAutor(@PathVariable String Autor){
        var ListaLibro = LibroService.FiltrarAutor(Autor);
        return new ResponseEntity<>(ListaLibro, HttpStatus.OK);
    }

    @GetMapping("FiltrarGenero/{Genero}")
    public ResponseEntity<Object> findGenero(@PathVariable String Genero){
        var ListaLibro = LibroService.FiltrarGenero(Genero);
        return new ResponseEntity<>(ListaLibro, HttpStatus.OK);
    }
    
    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        LibroService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Libro") Libro LibroUpdate){
        var Libro = LibroService.findOne(id).get();
        if(Libro != null){
            Libro.setTitulo(LibroUpdate.getTitulo());
            Libro.setAutor(LibroUpdate.getAutor());
            Libro.setGenero(LibroUpdate.getGenero());
            Libro.setEjemplaresDisponibles(LibroUpdate.getEjemplaresDisponibles());
            Libro.setEjemplaresOcupados(LibroUpdate.getEjemplaresOcupados());
            LibroService.save(Libro);
            return new ResponseEntity<>(Libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Libro no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
    

}
