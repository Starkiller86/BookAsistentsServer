package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Adult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**Esta es una interfaz de repositorio el cual se realciona la tabla "registroaduls", teniendo una variable de indentificación Integer
 * en esta parte se definen cada uno de los métodos CRUD los cuales son (CREAR, LEER, ELIMINAR y ACTUALIZAR) para que de esta manera se
 * puedan crear los registros de cada usuario en la base de datos bookAsistents
 * **/
public interface AdultRepository extends CrudRepository<Adult, Integer> {

    @Query(value = "SELECT * FROM registroaduls A WHERE (LOWER(CONCAT(A.nombre, ' ', A.apellido))) LIKE (LOWER(CONCAT('%',:nombreCompleto,'%')))", nativeQuery = true)
    List<Adult> findByNombreCompleto(@Param("nombreCompleto") String nombreCompleto);


}
