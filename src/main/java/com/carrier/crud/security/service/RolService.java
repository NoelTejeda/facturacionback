package com.carrier.crud.security.service;

import com.carrier.crud.security.entity.Rol;
import com.carrier.crud.security.enums.RolNombre;
import com.carrier.crud.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 *
 * @author Ing. Francisco Guevara
 */

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
