package com.sbcm.BookAsistentsServer.Services;

import com.sbcm.BookAsistentsServer.models.Adult;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FindUsersServiceAdult {


    @Transactional
    public Iterable<Adult> findUsersByName(String[] args){

        return  null;
    }
}
