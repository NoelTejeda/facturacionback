package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.NotadebitoOperadorModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface NotadebitoOperadorRepository extends CrudRepository<NotadebitoOperadorModel, Long>{
  public abstract ArrayList<NotadebitoOperadorModel> findByStatus(boolean status);

/*esto es:ATF- actualiza las notas de credito y arroja total en la tabla total  */
    /*envia siguiente parametros
        1er parametro  es el tipo de  facturacion: 1 MOVILNET 2 OPERADOR
        2do parametro  es el tipo de  nota: 1 DEBITO 2 CREDITO
        3er parametro  es el NUMERO DE FACTURA 
     */

    @Query( value = "SELECT * FROM public.f_consulta_factotal(2, 1,:factura_numero)", nativeQuery= true)


    public int updateNCTotal( @Param("factura_numero") String  factura_numero); 
  //  public int updateNCTotal( @Param("factura") Integer  factura,@Param("factura1") Integer  factura1,@Param("factura21") String  factura2); 
  
 
}
