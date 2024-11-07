package com.example.sistemadeimobliaria.repository;

import com.example.sistemadeimobliaria.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}

