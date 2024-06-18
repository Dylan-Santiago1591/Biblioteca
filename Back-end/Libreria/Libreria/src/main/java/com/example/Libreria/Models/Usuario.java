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
@Entity(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="IdUsuario", nullable = false, length =36)
    private String IdUsuario;

    @Column(name="Nombre", nullable = false, length = 45)
    private String Nombre;

    @Column(name="Apellido", nullable = false, length = 45)
    private String Apellido;

    @Column(name="Dirrecion", nullable = false, length = 35)
    private String Direccion;

    @Column(name="CorreoElectronico", nullable = false, length = 60)
    private String CorreoElectronico;

    @Column(name="TipoUsuario", nullable = false, length = 1)
    private char TipoUsuario;

}
