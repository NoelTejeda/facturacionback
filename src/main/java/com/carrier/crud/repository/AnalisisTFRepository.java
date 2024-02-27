package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.AnalisisTFModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface AnalisisTFRepository extends CrudRepository<AnalisisTFModel, Long>{
     public abstract ArrayList<AnalisisTFModel> findByStatus(boolean status);
}
