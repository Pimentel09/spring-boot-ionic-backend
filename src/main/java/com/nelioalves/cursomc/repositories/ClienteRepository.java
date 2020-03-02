package com.nelioalves.cursomc.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nelioalves.cursomc.domain.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
