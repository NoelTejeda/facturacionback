package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.OperadorModel;
import com.carrier.crud.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *  @author Ing. Francisco Guevara
 */
@Service
public class OperadorServices {
    @Autowired
    OperadorRepository operadorRepository;
    
    public ArrayList<OperadorModel> getOperadores(){
        return (ArrayList<OperadorModel>) operadorRepository.findAll();
    }
    
    public OperadorModel saveOperador(OperadorModel operador){
        return operadorRepository.save(operador);
    }
    
    public boolean existsByOperador(String operador){
        return operadorRepository.existsByOperador(operador);
    }
    
    public boolean existsByRif(String rif){
        return operadorRepository.existsByRif(rif);
    }
    
 
    public Optional<OperadorModel> getById(Long id){
        return operadorRepository.findById(id);
    }


    public ArrayList<OperadorModel>  getByStatus(Boolean status) {
        return operadorRepository.findByStatus(status);
    }

    public boolean deleteInvoice(Long id) {
        try{
            operadorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
    
}
