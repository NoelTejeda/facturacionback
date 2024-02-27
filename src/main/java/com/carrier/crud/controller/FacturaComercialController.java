package com.carrier.crud.controller;

import com.carrier.crud.service.FacturaComercialService;
import com.carrier.crud.entity.FacturaModel;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FranMovilnet
 */
@RestController
// @CrossOrigin(origins = "http://192.168.211.137", maxAge = 3600) // PRODUCCION
// @CrossOrigin(origins = "http://192.168.211.106", maxAge = 3600) // CALIDAD
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // LOCAL
@RequestMapping("/ix/api/v1/facturacomercial2")
public class FacturaComercialController {
    @Autowired
    FacturaComercialService facturaComercialService;

    private ArrayList facturas;

    static final Logger log = Logger.getLogger(FacturaComercialController.class.getName());

    @GetMapping()
    public ArrayList<FacturaModel> getFacturas(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("X-Frame-Options", "DENY");
        long startTime = System.currentTimeMillis();
        UUID id_transaccion = UUID.randomUUID();

        String ip = req.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        String usuario = req.getHeader("UserName");
        long endTime = System.currentTimeMillis() - startTime;
        if (usuario != null) {
            log.log(Level.INFO,
                    "Get Factura Comercial por el Usuario|{0}|{1}|Origen-{2}|Destino-{3}|GET|INTERCONECTADOS|FACTURACOMERCIAL|{4}|{5}|{6} ms|{7}",
                    new Object[] { LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.OK, req,
                            endTime, usuario });
        } else {
            log.log(Level.INFO, "Get Factura Comercial Error en el Nombre de Usuario|{0}|{1}|{2}|{3}|{4}|{5}|{6}|{7}",
                    new Object[] { LocalDate.now(), LocalTime.now(), id_transaccion, ip, ip, HttpStatus.NO_CONTENT, req,
                            endTime });
        }

        facturas = facturaComercialService.getFacturas();
        return facturas;
    }
}
