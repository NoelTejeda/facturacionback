package com.carrier.crud.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.FacturaModel;
import com.carrier.crud.service.FacturaGeneralServices;
import com.carrier.crud.service.FacturaServices;

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
@RequestMapping("/ix/api/v1/factura")
public class FacturaController {
    @Autowired
    FacturaServices facturaService;
    
    @Autowired
    FacturaGeneralServices facturaGeneralService;
        
    static final Logger log = Logger.getLogger(FacturaController.class.getName());
   
    @GetMapping()
    public ArrayList<FacturaModel> getFacturas(HttpServletRequest req, HttpServletResponse res){
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
            log.log(Level.INFO, "Get Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURA|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return facturaService.getFacturas();
    }  
    
    //EndPoint para agregar una sola Factura
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping()
    public FacturaModel saveFactura(HttpServletRequest req, @RequestBody FacturaModel factura, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Single Factura por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURASINGLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Single Factura Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
                        
        return this.facturaService.saveFactura(factura);
    }
 
    //------------------------------------------
    //EndPoint para Cargar Array de Objetos  -  Factura
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PostMapping("/post")
    public ArrayList saveAllFactura(HttpServletRequest req, @RequestBody ArrayList<FacturaModel> factura, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Array Factura por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURAMULTIPLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Array Factura Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaService.saveAllFactura(factura);
    }
    
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE')")
    @GetMapping( path = "/{id}")
    public Optional<FacturaModel> getById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res) {
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
            log.log(Level.INFO, "GetById Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURAID|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "GetById Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaService.getById(id);
    }

    //EndPoint de Anulacion de Factura
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC')")
    @PutMapping("/{id}")
    public FacturaModel updateFactura(HttpServletRequest req, @RequestBody FacturaModel factura, HttpServletResponse res){
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
            log.log(Level.INFO, "Updated Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|UPDATE|INTERCONECTADOS|ANULARFACTURA|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Updated Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        factura.setStatus(false);
        return factura;
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
            log.log(Level.INFO, "Delete Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|DELETE|INTERCONECTADOS|FACTURA|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Delete Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        boolean ok = this.facturaService.deleteFactura(id);
        if (ok){
            return "Se eliminó la Factura con id " + id;
        }else{
            return "No pudo eliminar la Factura con id" + id;
        }
    }*/
   
}
    

    
