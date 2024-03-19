package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Personaldatakid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KidPersonalRepository extends CrudRepository<Personaldatakid, Integer> {
    @Query(value = "SELECT id FROM personaldatakid WHERE id_kid = :idKid", nativeQuery = true)
    int findByKidId(@Param("idKid") int idK);
}
