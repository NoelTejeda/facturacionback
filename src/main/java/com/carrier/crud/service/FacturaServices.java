package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.FacturaModel;
import com.carrier.crud.repository.FacturaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Service
public class FacturaServices {
    @Autowired
    FacturaRepository facturaRepository;
    
    public ArrayList<FacturaModel> getFacturas(){
        return (ArrayList<FacturaModel>) facturaRepository.findAll();
    }
    
    public FacturaModel saveFactura(FacturaModel factura){
        return facturaRepository.save(factura);
    }
    
    public FacturaModel FiltrarFactura(Date fecha, Date fecha2){
        return facturaRepository.findByEnd_date(fecha, fecha2);
    }
    
    public ArrayList<FacturaModel> saveAllFactura(ArrayList<FacturaModel> factura){
        factura.forEach(facturas -> {
            facturaRepository.save(facturas);
        });
        return factura;
    }
    
    public FacturaModel updateFactura(FacturaModel factura){
        return facturaRepository.save(factura);
    }
    
    public Optional<FacturaModel> getById(Long id){
        return facturaRepository.findById(id);
    }


    public ArrayList<FacturaModel>  getByStatus(Boolean status) {
        return facturaRepository.findByStatus(status);
    }
    
    public boolean deleteFactura(Long id) {
        try{
            facturaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
   
}
