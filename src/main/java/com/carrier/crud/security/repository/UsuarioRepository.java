package com.carrier.crud.security.repository;

import com.carrier.crud.security.dto.NuevoUsuario;
import com.carrier.crud.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
    public void save(NuevoUsuario nuevoUsuario);

}
