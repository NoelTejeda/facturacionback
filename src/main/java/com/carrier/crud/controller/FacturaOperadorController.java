package com.carrier.crud.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.FacturaOperadorModel;
import com.carrier.crud.service.FacturaOperadorServices;
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
@RequestMapping("/ix/api/v1/facturaoperador")
public class FacturaOperadorController {
    @Autowired
    FacturaOperadorServices facturaOperadorService;
    
       Logger log = Logger.getLogger(FacturaOperadorController.class.getName());
    
    @GetMapping()
    public ArrayList<FacturaOperadorModel> getFacturasOperador(HttpServletRequest req, HttpServletResponse res){
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
            log.log(Level.INFO, "Get Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURAOPERADOR|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return facturaOperadorService.getFacturasOperador();
    }  
    
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping()
    public FacturaOperadorModel saveFacturaOperador(HttpServletRequest req, @RequestBody FacturaOperadorModel facturaOperador, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Single Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURAOPERADORSINGLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Single Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaOperadorService.saveFacturaOperador(facturaOperador);
    }
    
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('ADMIN')or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping("/post")
    public ArrayList<FacturaOperadorModel> saveAllFactura(HttpServletRequest req, @RequestBody ArrayList<FacturaOperadorModel> facturaOperador, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Array Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURAOPERADORMULTIPLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Array  Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaOperadorService.saveAllFactura(facturaOperador);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<FacturaOperadorModel> getById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res) {
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
            log.log(Level.INFO, "GetById Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURAOPERADORID|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "GetById Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaOperadorService.getById(id);
    }
    
    //EndPoint de Anulacion de Factura de Operadores
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PutMapping("/{id}")
    public FacturaOperadorModel updateFactura(HttpServletRequest req, @RequestBody FacturaOperadorModel facturaOperador, HttpServletResponse res){
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
            log.log(Level.INFO, "Updated Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|UPDATE|INTERCONECTADOS|FACTURAOPERADOR|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Updated Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        facturaOperador.setStatus(false);
        return facturaOperador;
    }

   
    @GetMapping("/query")
    public ArrayList<FacturaOperadorModel> getFacturaOperadorByStatus(HttpServletRequest req, @RequestParam("status") Boolean status, HttpServletResponse res){
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
            log.log(Level.INFO, "Get Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURAOPERADORSTATUS|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaOperadorService.getByStatus(status);
    }
    
    
    //@PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping( path = "/{id}")
    public String deleteById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res){
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
            log.log(Level.INFO, "Delete Factura Operador por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|DELETE|INTERCONECTADOS|FACTURAOPERADOR|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Delete Factura Operador Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        boolean ok = this.facturaOperadorService.deleteFacturaOperador(id);
        if (ok){
            return "Se eliminó la Factura Operador con id " + id;
        }else{
            return "No pudo eliminar la Factura Operador con id" + id;
        }
    }
    
}
