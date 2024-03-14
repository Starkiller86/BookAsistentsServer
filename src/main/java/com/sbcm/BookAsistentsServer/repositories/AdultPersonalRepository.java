package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Personaldataadult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdultPersonalRepository extends CrudRepository<Personaldataadult, Integer> {
    @Query(value = "SELECT id FROM registroaduls WHERE id_adulto = :idAdulto", nativeQuery = true)
    Personaldataadult findByAdultId(@Param("idAdulto") int idA);
}
