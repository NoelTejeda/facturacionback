package com.carrier.crud.repository;

import com.carrier.crud.entity.ServicioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Repository
public interface ServicioRepository extends CrudRepository<ServicioModel, Long> {
     boolean existsByDescripcion(String nombreUsuario);
     boolean existsByCodigo(Integer codigo);

    public boolean existsByCodigo(String codigo);
}
