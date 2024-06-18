package com.example.Libreria.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "IdLibro", nullable = false, length = 36)
    private String IdLibro;

    @Column(name = "Titulo", nullable = false, length = 45)
    private String Titulo;

    @Column(name = "Autor", nullable = false, length = 45)
    private String Autor;

    @Column(name = "Genero", nullable = false, length = 30)
    private String Genero;

    @Column(name = "EjemplaresDisponibles", nullable = false, length =20 )
    private int EjemplaresDisponibles;

    @Column(name = "EjemplaresOcupados", nullable = false, length = 20)
    private int EjemplaresOcupados;

    //FALTA ISBN
}
