package com.example.demo.serviceImpl;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioInterface {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String helloWorld() {
        return "Hola vv";
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Long usuarioId, Usuario datosActualizados) {
        if (usuarioId == null) {
            throw new RuntimeException("Manda un id pero querido amiko");
        }
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuarioId);
        if (usuarioEncontrado.isPresent()) {
            Usuario usuarioExistente = usuarioEncontrado.get();
            usuarioExistente = Usuario.builder()
                    .id(usuarioExistente.getId())
                    .nombre(datosActualizados.getNombre())
                    .build();
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    @Override
    public boolean eliminarUsuario(Long usuarioId) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
            usuario.ifPresent(value -> value.setActivo(false));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
