package com.carrier.crud.security.controller;

import com.carrier.crud.dto.Mensaje;
import com.carrier.crud.security.dto.JwtDto;
import com.carrier.crud.security.dto.LoginUsuario;
import com.carrier.crud.security.dto.NuevoUsuario;
import com.carrier.crud.security.entity.Rol;
import com.carrier.crud.security.entity.Usuario;
import com.carrier.crud.security.enums.RolNombre;
import com.carrier.crud.security.jwt.JwtProvider;
import com.carrier.crud.security.service.RolService;
import com.carrier.crud.security.service.UsuarioService;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Ing. Francisco Guevara
 */

@RestController
//@CrossOrigin(origins = "http://192.168.211.137", maxAge = 3600) // PRODUCCION
//@CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600) // CALIDAD
@CrossOrigin(origins="http://localhost:3000", maxAge = 3600)      // LOCALHOST
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    Logger log = Logger.getLogger(this.getClass().getName());

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult , HttpServletRequest req, HttpServletResponse res ){
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

       String usuarioReq = req.getHeader("UserName");
       
        // Retorno de BindingResult para manejar errores en la peticion
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Datos Invalidos"), HttpStatus.BAD_REQUEST);
       
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existente"), HttpStatus.BAD_REQUEST);
        Usuario usuario;
        usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.isStatus(),  LocalDate.now() );
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
        if(nuevoUsuario.getRoles().contains("enrutador"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ENRUTADOR).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        long endTime = System.currentTimeMillis() - startTime;
       
        log.log(Level.INFO, "Registro de Usuario Exitoso |{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|NUEVO|{4}|{5}|{6} ms|{7}{8}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, nuevoUsuario, endTime, usuarioReq});
        return new ResponseEntity(new Mensaje("Usuario Registrado Correctamente"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res){
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
        
        String usuarioReq = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;
        log.log(Level.INFO, "Ingreso a la Aplicacion Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|LOGIN|{4}|{5} ms|{6} ", new Object[]{LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, endTime, usuarioReq});
        if(bindingResult.hasErrors())   
            return new ResponseEntity(new Mensaje ("Datos Inválidos"), HttpStatus.BAD_REQUEST);
        
        Optional<Usuario> user  = usuarioService.getByNombreUsuario(usuarioReq);
        
        if(!user.get().isStatus())
            return new ResponseEntity(new Mensaje("Usuario Bloqueado"), HttpStatus.UNAUTHORIZED);
       
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
