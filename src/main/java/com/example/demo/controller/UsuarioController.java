package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xd")
public class UsuarioController {

    private final UsuarioInterface usuarioService;

    public UsuarioController(UsuarioInterface usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<String> saludar() {
        String saludo = usuarioService.helloWorld();
        return ResponseEntity.ok(saludo);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario saveUser = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(saveUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> users = usuarioService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioUpdate){
        Usuario usuario = usuarioService.updateUsuario(id, usuarioUpdate);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarUsuario(@PathVariable Long id) {
        boolean respuesta = usuarioService.eliminarUsuario(id);
        if (respuesta) {
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.badRequest().build();
    }
}
