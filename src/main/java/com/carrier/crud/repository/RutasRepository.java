package com.carrier.crud.repository;

import com.carrier.crud.entity.RutasModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FranMovilnet
 */

@Repository
public interface RutasRepository extends CrudRepository<RutasModel, Long> {
     public abstract ArrayList<RutasModel> findByid(Long id);
}
