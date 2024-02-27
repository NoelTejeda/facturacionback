package com.carrier.crud.repository;

import com.carrier.crud.entity.FacturaModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FranMovilnet
 */
public interface FacturaComercialRepository extends CrudRepository<FacturaModel, Long>{
    public abstract ArrayList<FacturaModel> findByStatus(boolean status);
}
