package com.carrier.crud.service;

import com.carrier.crud.entity.FacturaModel;
import com.carrier.crud.repository.FacturaComercialRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranMovilnet
 */
@Service
public class FacturaComercialService {
    @Autowired
    FacturaComercialRepository facturaComercialRepository;
    
    public ArrayList<FacturaModel> getFacturas(){
        return (ArrayList<FacturaModel>) facturaComercialRepository.findAll();
    }
      
    public FacturaModel saveFacturaComercialSinValor(FacturaModel factura){
        return facturaComercialRepository.save(factura);
    }
    
     public ArrayList<FacturaModel> saveAllFacturaSinValor(ArrayList<FacturaModel> factura){
        factura.forEach(facturas -> {
            facturaComercialRepository.save(facturas);
        });
        return factura;
    }
     
    public boolean deleteFacturaSinValor(Long id) {
        try{
            facturaComercialRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
