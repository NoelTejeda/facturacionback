package com.carrier.crud.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.NotaCreditoModel;
import com.carrier.crud.service.NotaCreditoServices;
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
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // LOCAL
@RequestMapping("/ix/api/v1/nota-credito")
public class NotacreditoController {
    @Autowired
    NotaCreditoServices notaCreditoService;
    
        Logger log = Logger.getLogger(this.getClass().getName());
    
    @GetMapping()
      public ArrayList<NotaCreditoModel> getNotaCredito(HttpServletRequest req, HttpServletResponse res){
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
            log.log(Level.INFO, "Get Nota de Credito por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Nota de Credito Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return notaCreditoService.getNotasCredito();
      }  

    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")      
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")      
    @PostMapping()
      public NotaCreditoModel saveNotacredito(HttpServletRequest req, @RequestBody NotaCreditoModel notacredito, HttpServletResponse res){
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
 System.out.println("notaCredito getCreated_at "+notacredito.getCreated_at());
        String usuario = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;
            
        if(usuario != null){
            log.log(Level.INFO, "Save Single Nota de Credito por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|NOTACREDITOSINGLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Single Nota de Credito Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.notaCreditoService.saveNotaCredito(notacredito);
    }

    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
     /*post es llamado desde el boton guardar del modal NC*/
     @PostMapping("/post")
    public ArrayList<NotaCreditoModel> saveAllNotaCredito(HttpServletRequest req, @RequestBody ArrayList<NotaCreditoModel> notaCredito, HttpServletResponse res){
res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
        UUID id_transaccion = UUID.randomUUID();

        System.out.println("notaCredito getCreated_at "+notaCredito.get(0).getCreated_at());
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
            log.log(Level.INFO, "Save Array Nota de Credito por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|NOTACREDITOMULTIPLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Array Nota de Credito Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.notaCreditoService.saveAllNotacredito(notaCredito);
    }      
         
     
    @GetMapping( path = "/{id}")
    public Optional<NotaCreditoModel> getById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res) {
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
            log.log(Level.INFO, "GetById Nota de Credito Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|NOTACREDITOID|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "GetById Nota de Credito Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.notaCreditoService.getById(id);
    }
    
    //EndPoint de Anulacion de Factura de Operadores
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PutMapping("/{id}")
    public NotaCreditoModel updateNotaCredito(HttpServletRequest req, @RequestBody NotaCreditoModel notaCredito, HttpServletResponse res){
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
            log.log(Level.INFO, "Updated Nota de Credito Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|UPDATE|INTERCONECTADOS|ANULARNOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Updated Nota de Credito Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        notaCredito.setStatus(false);
        return notaCredito;
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
            log.log(Level.INFO, "Delete Nota de Credito Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|DELETE|INTERCONECTADOS|NOTACREDITO|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Delete Nota de Credito Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        boolean ok = this.notaCreditoService.deleteNotaCredito(id);
        if (ok){
            return "Se eliminó la Nota de Credito con id " + id + " Correctamente!!";
        }else{
            return "No pudo eliminar el Credito con id" + id;
        }
    }*/
    
}
