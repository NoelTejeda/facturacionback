package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.AnalisisTFModel;
import com.carrier.crud.repository.AnalisisTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Service
public class AnalisisTFServices {
    @Autowired
    AnalisisTFRepository analisisTFRepository;
    
    public ArrayList<AnalisisTFModel> getAnalisisTF(){
        return (ArrayList<AnalisisTFModel>) analisisTFRepository.findAll();
    }
    
    public AnalisisTFModel saveAnalisisTF(AnalisisTFModel analisistf){
        return analisisTFRepository.save(analisistf);
    }
    
 
    public Optional<AnalisisTFModel> getById(Long id){
        return analisisTFRepository.findById(id);
    }


    public ArrayList<AnalisisTFModel>  getByStatus(Boolean status) {
        return analisisTFRepository.findByStatus(status);
    }

    public boolean deleteAnalisisTF(Long id) {
        try{
            analisisTFRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
}
