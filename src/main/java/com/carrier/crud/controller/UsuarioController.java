package com.carrier.crud.controller;

import com.carrier.crud.dto.Mensaje;
import com.carrier.crud.security.dto.NuevoUsuario;
import com.carrier.crud.security.entity.Rol;
import com.carrier.crud.security.entity.Usuario;
import com.carrier.crud.security.enums.RolNombre;
import com.carrier.crud.security.repository.UsuarioRepository;
import com.carrier.crud.security.service.RolService;
import com.carrier.crud.security.service.UsuarioService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Ing. Francisco Guevara
 */

@RestController
//@CrossOrigin(origins = "http://192.168.211.137", maxAge = 3600) // PRODUCCION
//@CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600) // CALIDAD
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // LOCAL
@RequestMapping("/ix/api/v1/usuarios")
public class UsuarioController{
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
     
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UsuarioRepository usuarioRepository;
    Logger log = Logger.getLogger(this.getClass().getName());
    
 
   
    @GetMapping()
    public ArrayList<Usuario> getUsuarios(HttpServletRequest req, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
        UUID id_transaccion = UUID.randomUUID();

        String ip = req.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        String usuario = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;            
        if(usuario != null){
            log.log(Level.INFO, "Get Usuarios por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Usuarios Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
      return usuarioService.getUsuarios();
    }  
    
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('SEG')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SEG')")
    @PostMapping("/editar")
    public ResponseEntity<?> editarUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult , HttpServletRequest req, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
        UUID id_transaccion = UUID.randomUUID();

        String ip = req.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        String usuarios = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;        
        Optional<Usuario> usuarioEdit = usuarioService.getByNombreUsuario(nuevoUsuario.getNombreUsuario());
        
        Set<Rol> roles = new HashSet<>();
        /*if(nuevoUsuario.getRoles().contains("superadmin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_SUPERADMIN).get());*/
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        if(nuevoUsuario.getRoles().contains("gerente"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_GER).get());
        if(nuevoUsuario.getRoles().contains("factc"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_FACTC).get());
        if(nuevoUsuario.getRoles().contains("facte"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_FACTE).get());
        if(nuevoUsuario.getRoles().contains("cobc"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_COBC).get());
        if(nuevoUsuario.getRoles().contains("cobe"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_COBE).get());
        if(nuevoUsuario.getRoles().contains("seguridad"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_SEG).get());
        if(nuevoUsuario.getRoles().contains("aprobadorfc"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_APROBADORFC).get());

        usuarioEdit.get().setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        usuarioEdit.get().setObservacion(nuevoUsuario.getObservacion());
        usuarioEdit.get().setStatus(true);
        usuarioEdit.get().setRoles(roles);
        usuarioService.save(usuarioEdit.get());
       
        log.log(Level.INFO, "Edicion de Usuario Exitoso por Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuarios});
        return new ResponseEntity(new Mensaje("Usuario Editado Correctamente"), HttpStatus.OK);
    }
    
    //EndPoint de Bloqueo de Usuario
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('SEG')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SEG')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(HttpServletRequest req, @RequestBody Usuario usuario, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
        UUID id_transaccion = UUID.randomUUID();

        String ip = req.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        String usuarios = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;            
        if(usuario != null){
            log.log(Level.INFO, "Updated Usuario por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuarios});
        }else{
            log.log(Level.INFO, "Updated Usuario Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        usuario.getObservacion();
        
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario Bloqueado Correctamente"), HttpStatus.OK);
    }    
}
