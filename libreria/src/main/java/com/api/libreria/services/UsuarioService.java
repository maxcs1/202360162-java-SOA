package com.api.libreria.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.libreria.models.UsuarioModel;
import com.api.libreria.repositories.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id)   ;
    }
    
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuarioActualizado) {
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe un usuario con ID: " + id));
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido(usuarioActualizado.getApellido());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        usuarioExistente.setContraseña(usuarioActualizado.getContraseña());
        usuarioExistente.setRol(usuarioActualizado.getRol());
        usuarioExistente.setEstado(usuarioActualizado.getEstado());
        usuarioExistente.setFechaCreacion(usuarioActualizado.getFechaCreacion());
        usuarioExistente.setFechaNacimiento(usuarioActualizado.getFechaNacimiento());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
        return usuarioRepository.save(usuarioExistente);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
