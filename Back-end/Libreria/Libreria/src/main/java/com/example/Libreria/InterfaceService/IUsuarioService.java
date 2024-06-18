package com.example.Libreria.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.example.Libreria.Models.Usuario;

public interface IUsuarioService {
    public String save(Usuario Usuario);
    public List<Usuario> findAll();
    public List<Usuario> FiltrarNombre(String Nombre);
    public List<Usuario> FiltrarApellido(String Apellido);
    public List<Usuario> FiltrarCorreoElectronico(String CorreoElectronico);
    public Optional<Usuario> findOne(String id);
    public boolean delete(String id);
}
