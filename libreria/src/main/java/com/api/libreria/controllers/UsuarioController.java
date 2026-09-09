package com.api.libreria.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.libreria.models.UsuarioModel;
import com.api.libreria.services.UsuarioService;

@RestController 
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired 
    private UsuarioService usuarioService;

    @GetMapping 
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }
    @PostMapping 
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }
    
    @PutMapping(path = "/{id}")
    public UsuarioModel actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuarioActualizado) {
        return this.usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con ID: " + id;
        } else {
            return "No se pudo eliminar el usuario con ID: " + id;
        }
    }
    
}
