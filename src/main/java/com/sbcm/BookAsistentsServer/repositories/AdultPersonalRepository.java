package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Personaldataadult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdultPersonalRepository extends CrudRepository<Personaldataadult, Integer> {
    @Query(value = "SELECT id FROM personaldataadult WHERE id_adulto = :idAdulto", nativeQuery = true)
    int findByAdultId(@Param("idAdulto") int idA);

    @Query(value = "SELECT COUNT(*) from personaldataadult e where e.id_adulto = :id", nativeQuery = true)
    int existByIdAdult(@Param("id") int id);

}
