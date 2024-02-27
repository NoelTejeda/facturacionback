package com.carrier.crud.security.repository;

import com.carrier.crud.security.entity.Rol;
import com.carrier.crud.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 *
 * @author Ing. Francisco Guevara
 */

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
