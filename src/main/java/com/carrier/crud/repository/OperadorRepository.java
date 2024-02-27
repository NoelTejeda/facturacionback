package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.OperadorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Repository
public interface OperadorRepository extends CrudRepository<OperadorModel, Long>{
    public abstract ArrayList<OperadorModel> findByStatus(boolean status);
    boolean existsByOperador(String operador);
    boolean existsByRif(String rif);
}
