package com.carrier.crud.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.AnalisisTFModel;
import com.carrier.crud.service.AnalisisTFServices;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ing. Francisco Guevara
 */
@RestController
//@CrossOrigin(origins = "http://192.168.211.137", maxAge = 3600) // PRODUCCION
//@CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600) // CALIDAD
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // LOCAL
@RequestMapping("/ix/api/v1/analisistf")
public class AnalisisTFController {
    @Autowired
    AnalisisTFServices analisisTFService;
    
    Logger log = Logger.getLogger(AnalisisTFController.class.getName());
    
    @GetMapping()
    public ArrayList<AnalisisTFModel> getAnalisisTF(HttpServletRequest req, HttpServletResponse res){
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
            log.log(Level.INFO, "Get Factura Sin Valor Comercial por el Usuario |{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NUEVO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}",  new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime}); 
        }
            
        return analisisTFService.getAnalisisTF();
    }  
    
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping()
    public AnalisisTFModel saveAnalisisTF(HttpServletRequest req, @RequestBody AnalisisTFModel analisisTF, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Single Factura Sin Valor Comercial por el Usuario |{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|NUEVO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Single Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}",  new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.analisisTFService.saveAnalisisTF(analisisTF);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<AnalisisTFModel> getById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res) {
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
        
        String usuarioReq = req.getHeader("UserName");
         
        long endTime = System.currentTimeMillis() - startTime;

        if(usuario != null){
            log.log(Level.INFO, "GetById Factura Sin Valor Comercial en el Nombre de Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|LOGIN|{4}|{5} ms|{6} ", new Object[]{LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, endTime, usuarioReq});
        }else{
            log.log(Level.INFO, "GetById Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.analisisTFService.getById(id);
    }

    
    @GetMapping("/query")
    public ArrayList<AnalisisTFModel> getByStatus(HttpServletRequest req, @RequestParam("status") Boolean status, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        String usuario = req.getHeader("UserName");
        
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

       if(usuario != null){
            log.log(Level.INFO, "GetByStatus Factura Sin Valor Comercial Nombre de Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|LOGIN|{4}|{5} Sms|{6} ", new Object[]{LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, endTime, usuarioReq});
        }else{
            log.log(Level.INFO, "GetByStatus Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}",  new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.analisisTFService.getByStatus(status);
    }
    /*
    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping( path = "/{id}")
    public String deleteById(HttpServletRequest req, @PathVariable("id") Long id){
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
            log.log(Level.INFO, "Delete Analisis Tecnico Financiero por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|NUEVO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Delete Analisis Tecnico Financiero Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}",  new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        boolean ok = this.analisisTFService.deleteAnalisisTF(id);
        if (ok){
            return "Se eliminó el Analisis Tecnico Financiero con id " + id;
        }else{
            return "No pudo eliminar el Analisis Tecnico Financiero con id" + id;
        }
    }*/
}
