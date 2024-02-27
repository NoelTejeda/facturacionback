package com.carrier.crud.util;

import com.carrier.crud.security.entity.Usuario;
import com.carrier.crud.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * IMPORTANTE: ESTA CLASE DESPUES DE SER EJECUTADA LA PRIMERA VEZ DEBE SER ELIMINADA O COMENTADA
 * 
 * @author Ing. Francisco Guevara
 */
@Component
public class CreateUser {
    
    @Autowired
    UsuarioService usuarioService;
    
    public void run(String... args) throws Exception {
        /*Usuario usuario = new Usuario();
        usuario.setNombre("Francisco Guevara");
        usuario.setNombreUsuario("fran");
        usuario.setEmail("franciscoguevara03@gmail.com");
        usuario.setPassword("123456");
        usario.setRoles(<>)
        usuarioService.save(usuario);*/
    }
}
