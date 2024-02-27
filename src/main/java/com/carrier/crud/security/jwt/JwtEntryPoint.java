package com.carrier.crud.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.logging.Logger;


/**
 *
 * @author Ing. Francisco Guevara
 */

@Component

//@CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@CrossOrigin(origins="http://localhost:3000", maxAge = 3600)      // LOCALHOST

public class JwtEntryPoint implements AuthenticationEntryPoint {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        log.warning("Intento fallido en JwtEntryPoint (metodo commence)");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
    }
}
