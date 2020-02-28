package com.nelioalves.cursomc.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nelioalves.cursomc.domain.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
