package com.ticketserver.ticketserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByUserName(String name);
    Iterable<User> findUserByUserName(String name);
    boolean existsUserByUserID(int userID);
    
}
