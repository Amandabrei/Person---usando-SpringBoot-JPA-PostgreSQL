package com.amanda.injecao_dependencias.repository;

import com.amanda.injecao_dependencias.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
