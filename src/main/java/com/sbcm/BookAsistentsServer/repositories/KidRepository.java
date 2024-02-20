package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Kid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**En esta parte la interfaz de repositorio se relaciona con la tabla kidsregister conteniendo una variable de identificación Integer
 * en esta parte del código se van a definir los métodos CRUD los cuales son (CREAR, LEER, ELIMINAR y ACTUALIZAR) para que de esta manera se
 * puedan crear los registros de los usuarios en la base de datos TableKids
 * **/

public interface KidRepository extends CrudRepository<Kid, Integer> {
    @Query(value = "SELECT * FROM kidsregister A WHERE (LOWER(CONCAT(A.nombre, ' ', A.apellido))) LIKE (LOWER(CONCAT('%', :nombreCompleto, '%')))", nativeQuery = true)
    List<Kid> findByNombreCompleto(@Param("nombreCompleto") String nombreCompleto);

    @Query(value = "SELECT MAX(ID) FROM kidsregister", nativeQuery = true)
    int findLasId();

}
