package com.DAT108_Oblig4_Del2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrangementRepo extends JpaRepository<Arrangement, Integer> {
	
    List<Arrangement> findAllById(int id);

    Arrangement findByNavn(String navn);
}
