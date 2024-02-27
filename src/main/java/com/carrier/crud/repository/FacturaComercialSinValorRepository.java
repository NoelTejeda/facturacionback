package com.carrier.crud.repository;

import com.carrier.crud.entity.FacturaSinValorModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Guevara
 */
@Repository
public interface FacturaComercialSinValorRepository extends CrudRepository<FacturaSinValorModel, Long>{
    public abstract ArrayList<FacturaSinValorModel> findByStatus(boolean status);
}
