package com.carrier.crud.controller;

import com.carrier.crud.entity.FacturaGeneralModel;
import com.carrier.crud.entity.FacturaModel;
import java.util.ArrayList;
import com.carrier.crud.service.FacturaGeneralServices;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ing. Francisco Guevara
 */
@RestController
//@CrossOrigin(origins = "http://192.168.211.137", maxAge = 3600) // PRODUCCION
//@CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600) // CALIDAD
@CrossOrigin(origins="http://localhost:3000", maxAge = 3600) // LOCAL
@RequestMapping("/ix/api/v1/facturageneral")
public class FacturaGeneralController {
    @Autowired
    FacturaGeneralServices facturaGeneralService;
        
    static final Logger log = Logger.getLogger(FacturaGeneralController.class.getName());
   
    @GetMapping()
    public ArrayList<FacturaGeneralModel> getFacturas(HttpServletRequest req, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
     log.log(Level.INFO, "getFacturas|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURA|{4}|{5}|{6} ms|{7}");
  
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
            log.log(Level.INFO, "Get Factura General por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURA|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Factura General Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
                
        return facturaGeneralService.getFacturasGenerales();
    } 
    
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping()
    public ResponseEntity<?> save(HttpServletRequest req, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Factura General Filtrada por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURA|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Factura General Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
       
        try {
            facturaGeneralService.saveFacturaGeneral();
            return new ResponseEntity("OK", HttpStatus.CREATED);
        }
        catch(Exception e) {
            log.info("Error al Momento de Crear Facturas a traves del CDR - " + e);
        }
        
        return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
    }

}
    

    
