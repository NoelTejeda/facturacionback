package com.carrier.crud.controller;

import com.carrier.crud.entity.FacturaSinValorModel;
import com.carrier.crud.service.FacturaComercialSinValorServices;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
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
@RequestMapping("/ix/api/v1/facturacomercial")
public class FacturaComercialSinValorController {
    @Autowired
    FacturaComercialSinValorServices facturaComercialSinValorService;
    
    private ArrayList facturas;
    
    Logger log = Logger.getLogger(FacturaComercialSinValorController.class.getName());
          
    @GetMapping()
    public ArrayList<FacturaSinValorModel> getFacturas(HttpServletRequest req, HttpServletResponse res){
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
                log.log(Level.INFO, "Get Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURACOMERCIAL|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
            }else{
                log.log(Level.INFO, "Get Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
            }
            
            facturas = facturaComercialSinValorService.getFacturas();
        return facturas;
    }  
    
    // EL APROBADOR ( aprobadorfc )DE FACTURAS COMERCIALES NO PUEDE AGREGAR FACTURAS SOLO APROBAR Y ANULAR
    //EndPoint para agregar una sola Factura

    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE') or hasRole('APROBADORFC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE') or hasRole('APROBADORFC')")
    @PostMapping()
    public FacturaSinValorModel saveFacturaComercialSinValor(HttpServletRequest req, @RequestBody FacturaSinValorModel facturaSinValor, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Single Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURACOMERCIALSINGLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Single Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaComercialSinValorService.saveFacturaComercialSinValor(facturaSinValor);
    }
    
    //EndPoint para Cargar Array de Objetos  -  Factura
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE') or hasRole('APROBADORFC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('FACTE') or hasRole('APROBADORFC')")
    @PostMapping("/post")
    public ArrayList<FacturaSinValorModel> saveAllFactura(HttpServletRequest req, @RequestBody ArrayList<FacturaSinValorModel> facturaSinValor, HttpServletResponse res){
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
            log.log(Level.INFO, "Save Array Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|POST|INTERCONECTADOS|FACTURACOMERCIALMULTIPLE|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Save Array Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaComercialSinValorService.saveAllFacturaSinValor(facturaSinValor);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<FacturaSinValorModel> getById(HttpServletRequest req, @PathVariable("id") Long id, HttpServletResponse res) {
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
            log.log(Level.INFO, "Get ID Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GETID|INTERCONECTADOS|FACTURACOMERCIALID|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Get ID Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        return this.facturaComercialSinValorService.getById(id);
    }

    //EndPoint de Anulacion de Factura
    // @PreAuthorize("hasRole('SUPERADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('APROBADORFC')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('GER') or hasRole('FACTC') or hasRole('APROBADORFC')")
    @PutMapping("/{id}")
    public FacturaSinValorModel updateFacturaSinValor(HttpServletRequest req, @RequestBody FacturaSinValorModel facturaSinValor, HttpServletResponse res){
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
            log.log(Level.INFO, "Updated Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|UPDATE|INTERCONECTADOS|ANULARFACTURACOMERCIAL|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Updated Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        facturaSinValor.setStatus(false);
        return facturaSinValor;
    }
    
    // ANTES QUE PASE A PRODUCCIÓN ELIMINAR EL ROL SUPERADMIN
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
            log.log(Level.INFO, "Delete Factura Sin Valor Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|DELETE|INTERCONECTADOS|FACTURACOMERCIAL|{4}|{5}|{6} ms|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req , endTime, usuario});
        }else{
            log.log(Level.INFO, "Delete Factura Sin Valor Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}", new Object[]{LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req , endTime});
        }
        
        boolean ok = this.facturaComercialSinValorService.deleteFacturaSinValor(id);
        if (ok){
            return "Se eliminó la Factura Comercial Prueba Sin Valor con id " + id;
        }else{
            return "No pudo eliminar la Factura Comercial Prueba Sin Valor con id" + id;
        }
    }*/

}
