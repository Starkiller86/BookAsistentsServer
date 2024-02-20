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

    //A diferencia del repositorio de Kid este contiene una consulta SQL que nos arroja todos los adultos que cumplan con el formato del nombre
    @Query(value = "SELECT * FROM registroaduls A WHERE (LOWER(CONCAT(A.nombre, ' ', A.apellido))) LIKE (LOWER(CONCAT('%',:nombreCompleto,'%')))", nativeQuery = true)
    List<Adult> findByNombreCompleto(@Param("nombreCompleto") String nombreCompleto);

    @Query(value = "SELECT MAX(r.id) FROM registroaduls r", nativeQuery = true)
    int findLasId();

}
