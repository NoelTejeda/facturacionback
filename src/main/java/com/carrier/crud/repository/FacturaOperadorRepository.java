package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.FacturaOperadorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface FacturaOperadorRepository extends CrudRepository<FacturaOperadorModel, Long>{
    public abstract ArrayList<FacturaOperadorModel> findByStatus(boolean status);
}
