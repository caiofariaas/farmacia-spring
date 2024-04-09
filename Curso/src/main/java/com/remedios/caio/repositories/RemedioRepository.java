package com.remedios.caio.repositories;

import com.remedios.caio.entities.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio, Long>{
    List<Remedio> findAllByAtivoTrue();
}
