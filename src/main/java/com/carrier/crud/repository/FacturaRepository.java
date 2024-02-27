package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.FacturaModel;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface FacturaRepository extends CrudRepository<FacturaModel, Long>{
    public abstract ArrayList<FacturaModel> findByStatus(boolean status);
    
    @Query (value = "select * from consulta(?,?)", nativeQuery = true)
    public FacturaModel findByEnd_date(Date fecha, Date fecha2);

    
}
