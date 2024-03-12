package com.sbcm.BookAsistentsServer.repositories;

import com.sbcm.BookAsistentsServer.models.Personaldataadult;
import org.springframework.data.repository.CrudRepository;

public interface AdultPersonalRepository extends CrudRepository<Personaldataadult, Integer> {
}
