package com.carrier.crud.security.service;

import com.carrier.crud.security.dto.NuevoUsuario;
import com.carrier.crud.security.entity.Usuario;
import com.carrier.crud.security.repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<Usuario> getUsuarios(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void save(NuevoUsuario nuevoUsuario) {
        usuarioRepository.save(nuevoUsuario);
    }
}
