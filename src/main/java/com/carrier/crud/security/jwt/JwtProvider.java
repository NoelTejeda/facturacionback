package com.carrier.crud.security.jwt;

import com.carrier.crud.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 *
 * @author Ing. Francisco Guevara
 */

@Component
public class JwtProvider {
   Logger log = Logger.getLogger(this.getClass().getName());

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .claim("nombreUsuario", usuarioPrincipal.getUsername())
                .claim("nombre", usuarioPrincipal.getNombre())
                .claim("email", usuarioPrincipal.getEmail())
                .claim("rol", usuarioPrincipal.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            log.warning("Token mal formado");
        }catch (UnsupportedJwtException e){
            log.warning("Token no soportado");
        }catch (ExpiredJwtException e){
            log.warning("Token expirado");
        }catch (IllegalArgumentException e){
            log.warning("Token vacío");
        }catch (SignatureException e){
            log.warning("Falla en la firma");
        }
        return false;
    }
}
