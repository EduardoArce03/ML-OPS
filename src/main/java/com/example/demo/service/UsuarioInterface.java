package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface UsuarioInterface {
    String helloWorld();

    public Usuario saveUsuario(Usuario usuario);

    public List<Usuario> getAllUsers();

    public Usuario updateUsuario(Long usuarioId, Usuario datosActualizados);

    public boolean eliminarUsuario(Long usuarioId);
}
