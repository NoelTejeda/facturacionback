package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.FacturaOperadorModel;
import com.carrier.crud.repository.FacturaOperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara 
 */
@Service
public class FacturaOperadorServices {
    @Autowired
    FacturaOperadorRepository facturaOperadorRepository;
    
    public ArrayList<FacturaOperadorModel> getFacturasOperador(){
        return (ArrayList<FacturaOperadorModel>) facturaOperadorRepository.findAll();
    }
    
    public FacturaOperadorModel saveFacturaOperador(FacturaOperadorModel facturaOperador){
        return facturaOperadorRepository.save(facturaOperador);
    }
    
    public ArrayList<FacturaOperadorModel> saveAllFactura(ArrayList<FacturaOperadorModel> facturaOperador){
        facturaOperador.forEach(facturas -> {
            facturaOperadorRepository.save(facturas);
        });
        return facturaOperador;
    }
    
 
    public Optional<FacturaOperadorModel> getById(Long id){
        return facturaOperadorRepository.findById(id);
    }


    public ArrayList<FacturaOperadorModel>  getByStatus(Boolean status) {
        return facturaOperadorRepository.findByStatus(status);
    }

    public boolean deleteFacturaOperador(Long id) {
        try{
            facturaOperadorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
    
}
