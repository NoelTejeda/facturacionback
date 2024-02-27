package com.carrier.crud.repository;

import java.util.ArrayList;
import com.carrier.crud.entity.NotadebitoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Repository
public interface NotadebitoRepository extends CrudRepository<NotadebitoModel, Long >{
        public abstract ArrayList<NotadebitoModel> findByStatus(boolean status);
        public abstract ArrayList<NotadebitoModel> findByOperador(String operador);

       /*esto es:ATF- actualiza las notas de credito y arroja total en la tabla total  */
    /*envia siguiente parametros
        1er parametro  es el tipo de  facturacion: 1 MOVILNET 2 OPERADOR
        2do parametro  es el tipo de  nota: 1 DEBITO 2 CREDITO
        3er parametro  es el NUMERO DE FACTURA PRINCIPAL DE OPERADOR QUE SE REGISTRA
     */

    @Query( value = "SELECT * FROM public.f_consulta_factotal(1, 1,:numero_factura)", nativeQuery= true)
 
    public int updateNDTotal( @Param("numero_factura") String  factura);

}
