package com.riwi.assessment.domain.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.riwi.assessment.domain.entities.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
    // List<Users>  findByCouponsById(Long id);
}
