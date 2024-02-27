package com.carrier.crud.security.enums;

import com.carrier.crud.security.entity.Rol;
import java.util.Set;


/**
 *
 * @author Ing. Francisco Guevara
 */

public enum RolNombre {
    /*ROLE_SUPERADMIN,*/
    ROLE_ADMIN, 
    ROLE_GER, 
    ROLE_FACTC, 
    ROLE_FACTE, 
    ROLE_COBC, 
    ROLE_COBE,
    ROLE_USER,
    ROLE_SEG,
    ROLE_APROBADORFC,
    ROLE_ENRUTADOR;

    public Set<Rol> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
