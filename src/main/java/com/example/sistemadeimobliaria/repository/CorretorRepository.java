package com.example.sistemadeimobliaria.repository;

import com.example.sistemadeimobliaria.model.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor, Integer> {
}
