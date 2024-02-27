package com.carrier.crud.controller;

import java.util.ArrayList;
import com.carrier.crud.entity.FacturaModel;
import com.carrier.crud.service.FacturaServices;

import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class FacturaAgrupadaController {
    @Autowired
    FacturaServices facturaService;
        
    static final Logger log = Logger.getLogger(FacturaAgrupadaController.class.getName());
        
    @GetMapping("/agrupar")
    public ArrayList<FacturaModel> getFacturas(HttpServletRequest req, HttpServletResponse res) { 
res.setHeader("X-Frame-Options", "DENY");
        return null;
    }
   
}
    

    
