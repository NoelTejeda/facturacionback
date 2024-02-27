package com.carrier.crud.util;

import com.carrier.crud.security.entity.Rol;
import com.carrier.crud.security.enums.RolNombre;
import com.carrier.crud.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * IMPORTANTE: ESTA CLASE SÓLO SE EJECUTAR�? UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBER�? ELIMINAR O BIEN COMENTAR EL CÓDIGO
 * 
 *
 *
 * @author Ing. Francisco Guevara
 
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
      /* Rol rolSuperAdmin = new Rol(RolNombre.ROLE_SUPERADMIN);
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolGer = new Rol(RolNombre.ROLE_GER);
        Rol rolFactC = new Rol(RolNombre.ROLE_FACTC);
        Rol rolFactE = new Rol(RolNombre.ROLE_FACTE);
        Rol rolCobC = new Rol(RolNombre.ROLE_COBC);
        Rol rolCobE = new Rol(RolNombre.ROLE_COBE);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolSeg = new Rol(RolNombre.ROLE_SEG);
        Rol rolAprobadorfc = new Rol(RolNombre.ROLE_APROBADORFC);
        Rol rolEnrutador = new Rol(RolNombre.ROLE_ENRUTADOR);
        rolService.save(rolSuperAdmin);
        rolService.save(rolAdmin);
        rolService.save(rolGer);
        rolService.save(rolFactC);
        rolService.save(rolFactE);
        rolService.save(rolCobC);
        rolService.save(rolCobE);
        rolService.save(rolUser);
        rolService.save(rolSeg);
        rolService.save(rolAprobadorfc);
        rolService.save(rolEnrutador);
      */


        
    }
}
