package com.carrier.crud.repository;

import com.carrier.crud.entity.FacturaGeneralModel;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface FacturaGeneralRepository extends CrudRepository<FacturaGeneralModel, Long>{
    public abstract ArrayList<FacturaGeneralModel> findByClient(String client);
    
    @Query( value = "SELECT * FROM consulta('2021/02/01','2025/12/31')", nativeQuery= true)
    boolean saveFacturaGeneral(); 
    


}
