package com.sbcm.BookAsistentsServer.Services;

import com.sbcm.BookAsistentsServer.models.Kid;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

public class FindUsersServiceKid {

    @Service
    public class FindUserServiceKid{
        @Transactional
        public Iterable<Kid> FindUsersByNameKid(String[] args){
            return null;
        }
    }
}
