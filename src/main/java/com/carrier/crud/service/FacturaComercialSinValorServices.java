package com.carrier.crud.service;

import com.carrier.crud.entity.FacturaSinValorModel;
import com.carrier.crud.repository.FacturaComercialSinValorRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Service
public class FacturaComercialSinValorServices {
    @Autowired
    FacturaComercialSinValorRepository facturaComercialSinValorRepository;
    
    public ArrayList<FacturaSinValorModel> getFacturas(){
        return (ArrayList<FacturaSinValorModel>) facturaComercialSinValorRepository.findAll();
    }
      
    public FacturaSinValorModel saveFacturaComercialSinValor(FacturaSinValorModel facturaSinValor){
        return facturaComercialSinValorRepository.save(facturaSinValor);
    }
    
    public ArrayList<FacturaSinValorModel> saveAllFacturaSinValor(ArrayList<FacturaSinValorModel> facturaSinValor){
        facturaSinValor.forEach(facturasSinValor -> {
            facturaComercialSinValorRepository.save(facturasSinValor);
        });
        return facturaSinValor;
    }
    
    public FacturaSinValorModel updateFacturaSinValor(FacturaSinValorModel facturaSinValor){
        return facturaComercialSinValorRepository.save(facturaSinValor);
    }
    
    public Optional<FacturaSinValorModel> getById(Long id){
        return facturaComercialSinValorRepository.findById(id);
    }


    public ArrayList<FacturaSinValorModel>  getByStatus(Boolean status) {
        return facturaComercialSinValorRepository.findByStatus(status);
    }
    
    public boolean deleteFacturaSinValor(Long id) {
        try{
            facturaComercialSinValorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
