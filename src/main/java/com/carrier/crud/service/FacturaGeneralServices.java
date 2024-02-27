package com.carrier.crud.service;

import com.carrier.crud.entity.FacturaGeneralModel;
import java.util.ArrayList;
import java.util.Optional;
import com.carrier.crud.entity.FacturaModel;
import com.carrier.crud.repository.FacturaGeneralRepository;
import com.carrier.crud.repository.FacturaRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Service
public class FacturaGeneralServices {
    @Autowired
    FacturaGeneralRepository facturaGeneralRepository;
    
    public ArrayList<FacturaGeneralModel> getFacturasGenerales(){
        return (ArrayList<FacturaGeneralModel>) facturaGeneralRepository.findAll();
    }
    
    public boolean saveFacturaGeneral(){
            facturaGeneralRepository.saveFacturaGeneral();
        return true;
    }
}
