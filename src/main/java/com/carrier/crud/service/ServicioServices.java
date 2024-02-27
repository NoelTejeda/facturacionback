package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.ServicioModel;
import com.carrier.crud.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *  @author Ing. Francisco Guevara
 * 
 * 
 */

@Service
public class ServicioServices {
    @Autowired
    ServicioRepository servicioRepository;
    
    public ArrayList<ServicioModel> getServicios(){
        return (ArrayList<ServicioModel>) servicioRepository.findAll();
    }
    
    public ServicioModel saveServicio(ServicioModel servicio){
        return servicioRepository.save(servicio);
    }
    
   public Optional<ServicioModel> getById(Long id){
       return servicioRepository.findById(id);
   } 
   public boolean existsByDescripcion(String descripcion){
        return servicioRepository.existsByDescripcion(descripcion);
    }
   public boolean existsByCodigo(String codigo){
        return servicioRepository.existsByCodigo(codigo);
    }
   
   public boolean deleteServicio(Long id){
       try{
           servicioRepository.deleteById(id);
           return true;
       }catch(Exception err){
           System.out.println(err);
           return false;
       }
   }

    public ArrayList<ServicioModel> getByStatus(Boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
