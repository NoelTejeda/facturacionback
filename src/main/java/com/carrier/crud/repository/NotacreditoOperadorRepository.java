package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.NotacreditoOperadorModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Repository
public interface NotacreditoOperadorRepository extends CrudRepository<NotacreditoOperadorModel, Long>{
     public abstract ArrayList<NotacreditoOperadorModel> findByStatus(boolean status);

 /*esto es:ATF- actualiza las notas de credito y arroja total en la tabla total  */
    /*envia siguiente parametros
        1er parametro  es el tipo de  facturacion: 1 MOVILNET 2 OPERADOR
        2do parametro  es el tipo de  nota: 1 DEBITO 2 CREDITO
        3er parametro  es el NUMERO DE FACTURA PRINCIPAL DE OPERADOR QUE SE REGISTRA
     */

    @Query( value = "SELECT * FROM public.f_consulta_factotal(2, 2,:numero_factura)", nativeQuery= true)
    public int updateNCTotal( @Param("numero_factura") String  numero_factura); 
  

}
