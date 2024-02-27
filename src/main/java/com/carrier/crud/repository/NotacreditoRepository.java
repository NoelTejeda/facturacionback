package com.carrier.crud.repository;

import com.carrier.crud.entity.FacturaModel;
import java.util.ArrayList;
import com.carrier.crud.entity.NotaCreditoModel;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface NotacreditoRepository extends CrudRepository<NotaCreditoModel, Long> {
      public abstract ArrayList<NotaCreditoModel> findByStatus(boolean status);

  
    
    /*esto es:ATF- actualiza las notas de credito y arroja total en la tabla total  */
    /*envia siguiente parametros
        1er parametro  es el tipo de  facturacion: 1 MOVILNET 2 OPERADOR
        2do parametro  es el tipo de  nota: 1 DEBITO 2 CREDITO
        3er parametro  es el NUMERO DE FACTURA
     */

    @Query( value = "SELECT * FROM public.f_consulta_factotal(1, 2,:factura) ", nativeQuery= true)
    public int updateNCTotal( @Param("factura") String  factura); 

}
