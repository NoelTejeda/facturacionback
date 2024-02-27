package com.carrier.crud.service;

import com.carrier.crud.entity.RutasModel;
import com.carrier.crud.repository.RutasRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranMovilnet
 */

@Service
public class RutasServices {
    @Autowired
    RutasRepository rutasRepository;
    
    public ArrayList<RutasModel> getRutas(){
        return (ArrayList<RutasModel>) rutasRepository.findAll();
    }
    
    public RutasModel saveRuta(RutasModel ruta){
        return rutasRepository.save(ruta);
    }

    public boolean deleteRuta(Long id) {
        try{
            rutasRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }
    
}
