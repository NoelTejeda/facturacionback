package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.NotadebitoModel;
import com.carrier.crud.repository.NotadebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Service
public class NotadebitoServices {
    @Autowired
    NotadebitoRepository notadebitoRepository;

    public ArrayList<NotadebitoModel> getNotasDebito(){
        return (ArrayList<NotadebitoModel>) notadebitoRepository.findAll();
    }
    
    public ArrayList<NotadebitoModel> findByOperador(String operador){
        return (ArrayList<NotadebitoModel>) notadebitoRepository.findByOperador(operador);
    }
    
    public NotadebitoModel saveNotadebito(NotadebitoModel notadebito){
        return notadebitoRepository.save(notadebito);
    }
    
    public ArrayList<NotadebitoModel> saveAllNotadebito(ArrayList<NotadebitoModel> notaDebito){
        notaDebito.forEach(notas -> {
            notadebitoRepository.save(notas);

            /* valor obtiene el id de la factura*/ 
             // no se esta usando la variable valor 
        //int valor =  Integer.parseInt(String.valueOf(notas.getNumero_factura()));

           // System.out.println(" valorxxxxxxxxxxxxx "+notas.getFactura());

            /*se crea la función  updateNDTotal y se ejecuta en NotaDebitoRepository pasando los datos
            y el tipo de dato debe ser igual a como esta en Entity(NotadebitoModel)*/

            notadebitoRepository.updateNDTotal(notas.getFactura());

  


        });
        return notaDebito;
    }
 
    public Optional<NotadebitoModel> getById(Long id){
        return notadebitoRepository.findById(id);
    }


    public ArrayList<NotadebitoModel>  getByStatus(Boolean status) {
        return notadebitoRepository.findByStatus(status);
    }

    public boolean deleteNotadebito(Long id) {
        try{
            notadebitoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
      
    
}
