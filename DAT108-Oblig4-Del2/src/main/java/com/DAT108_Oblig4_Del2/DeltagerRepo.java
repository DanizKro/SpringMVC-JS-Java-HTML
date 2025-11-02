package com.DAT108_Oblig4_Del2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepo extends JpaRepository<Deltager, Integer>{
	Deltager findByMobil(String mobil);
}
