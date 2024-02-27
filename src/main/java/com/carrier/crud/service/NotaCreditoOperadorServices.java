package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.NotacreditoOperadorModel;
import com.carrier.crud.repository.NotacreditoOperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Service
public class NotaCreditoOperadorServices {
    @Autowired
    NotacreditoOperadorRepository notacreditoOperadorRepository;
      
    public ArrayList<NotacreditoOperadorModel> getNotasCredito(){
        return (ArrayList<NotacreditoOperadorModel>) notacreditoOperadorRepository.findAll();
    }
    
    public NotacreditoOperadorModel saveNotaCredito(NotacreditoOperadorModel notacredito){

        
return notacreditoOperadorRepository.save(notacredito);
  
    }

    public ArrayList<NotacreditoOperadorModel> saveAllNotacreditoOperador(ArrayList<NotacreditoOperadorModel> notacreditoOperador){
      
        System.out.println(" NotaCreditoOperadorServices.saveAllNotacreditoOperador"); 

            
   System.out.println(" NotaCreditoOperadorServices.saveAllNotacreditoOperador "+notacreditoOperador.get(0).getNumero_factura()); 



notacreditoOperador.forEach(notas -> {

            notacreditoOperadorRepository.save(notas);
        /* valor obtiene el id de la factura*/ 
             // no se esta usando la variable valor 
        //int valor =  Integer.parseInt(String.valueOf(notas.getNumero_factura()));

            System.out.println(" valor getNumero_factura "+notas.getNumero_factura());

            /*se crea la función  updateNCTotal y se ejecuta en NotacreditoRepository pasando los datos*/
            notacreditoOperadorRepository.updateNCTotal(notas.getNumero_factura());
  
        });

        return notacreditoOperador;
    }
    
    public NotacreditoOperadorModel updateFactura(NotacreditoOperadorModel notacreditoOperador){
      
  return notacreditoOperadorRepository.save(notacreditoOperador);
    }    
 
    public Optional<NotacreditoOperadorModel> getById(Long id){
        return notacreditoOperadorRepository.findById(id);
    }


    public ArrayList<NotacreditoOperadorModel>  getByStatus(Boolean status) {
        return notacreditoOperadorRepository.findByStatus(status);
    }

    public boolean deleteNotaCredito(Long id) {
        try{
            notacreditoOperadorRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }

}
