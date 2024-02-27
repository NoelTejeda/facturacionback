package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.NotadebitoModel;
import com.carrier.crud.entity.NotadebitoOperadorModel;
import com.carrier.crud.repository.NotadebitoOperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Service
public class NotadebitoOperadorServices {
    @Autowired
    NotadebitoOperadorRepository notadebitoOperadorRepository;
    
    public ArrayList<NotadebitoOperadorModel> getNotasDebitoOperadores(){
        return (ArrayList<NotadebitoOperadorModel>) notadebitoOperadorRepository.findAll();
    }
    
    public NotadebitoOperadorModel saveNotaDebito(NotadebitoOperadorModel notadebito){
 System.out.println("NotaCreditoServices saveNotaDebito ");
        return notadebitoOperadorRepository.save(notadebito);
    }
    
            /***************************/

    public ArrayList<NotadebitoOperadorModel> saveAllNotadebitoOperador(ArrayList<NotadebitoOperadorModel> notadebitoOperador){
        notadebitoOperador.forEach(facturas -> {
            notadebitoOperadorRepository.save(facturas);
//  System.out.println("saveAllNotadebitoOperador saveAllNotadebitoOperador "+facturas.getId());
 /* valor obtiene el id de la factura*/              
    int valor =  Integer.parseInt(String.valueOf(facturas.getFactura_numero()));
           System.out.println(" valor YAIRRRR "+valor);

    /*se crea la función  updateNCTotal y se ejecuta en NotacreditoRepository pasando los datos*/
    notadebitoOperadorRepository.updateNCTotal(facturas.getFactura_numero());
 System.out.println("NotadebitoOperadorServices saveAllNotadebitoOperador******* "+notadebitoOperadorRepository);
        });
        return notadebitoOperador;
    }



         /***************************/
    
    public NotadebitoOperadorModel updateNotadebitoOperador(NotadebitoOperadorModel notadebitoOperador){
System.out.println("NotadebitoOperadorServices updateNotadebitoOperador ");        
return notadebitoOperadorRepository.save(notadebitoOperador);
    }
    
 
    public Optional<NotadebitoOperadorModel> getById(Long id){
        return notadebitoOperadorRepository.findById(id);
    }


    public ArrayList<NotadebitoOperadorModel>  getByStatus(Boolean status) {
        return notadebitoOperadorRepository.findByStatus(status);
    }

    public boolean deleteNotaDebito(Long id) {
        try{
            notadebitoOperadorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }

    public NotadebitoModel saveNotaDebito(NotadebitoModel notadebito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
