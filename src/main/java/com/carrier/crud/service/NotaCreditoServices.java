package com.carrier.crud.service;

import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.NotaCreditoModel;
import com.carrier.crud.repository.NotacreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Ing. Francisco Guevara
 */

@Service
public class NotaCreditoServices {
    @Autowired
    NotacreditoRepository notacreditoRepository;
    
    /*recibe los datos de NC*/  
    public ArrayList<NotaCreditoModel> getNotasCredito(){
        return (ArrayList<NotaCreditoModel>) notacreditoRepository.findAll();
    }
    
    public NotaCreditoModel saveNotaCredito(NotaCreditoModel notacredito){
        return notacreditoRepository.save(notacredito);
    }
    
    /* guarda las NC del modal NC*/
    public ArrayList<NotaCreditoModel> saveAllNotacredito(ArrayList<NotaCreditoModel> notaCredito){
        notaCredito.forEach(notas -> {
            notacreditoRepository.save(notas);
          //  System.out.println("NotaCreditoServices "+notas );
          //System.out.println("NotaCreditoServices fatura "+notas.getFactura());
    
    /* valor obtiene el id de la factura*/              
    //int valor =  Integer.parseInt(String.valueOf(notas.getFactura()));
            System.out.println(" valoryyyyyyyyyy "+notas.getFactura());

    /*se crea la función  updateNCTotal y se ejecuta en NotacreditoRepository pasando los datos*/
    notacreditoRepository.updateNCTotal(notas.getFactura());

        });
        return notaCredito;
    }
 
    public Optional<NotaCreditoModel> getById(Long id){
        return notacreditoRepository.findById(id);
    }


    public ArrayList<NotaCreditoModel>  getByStatus(Boolean status) {
        return notacreditoRepository.findByStatus(status);
    }

    public boolean deleteNotaCredito(Long id) {
        try{
            notacreditoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
}
