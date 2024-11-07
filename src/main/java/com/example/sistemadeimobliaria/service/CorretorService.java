package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.CorretorDto;
import com.example.sistemadeimobliaria.model.Corretor;
import com.example.sistemadeimobliaria.repository.ContratoRepository;
import com.example.sistemadeimobliaria.repository.CorretorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public List<CorretorDto> getAllCorretors() {
        return corretorRepository
                .findAll()
                .stream()
                .map(corretor -> CorretorDto
                        .builder()
                        .nome(corretor.getNome())
                        .cpf(corretor.getCpf())
                        .email(corretor.getEmail())
                        .telefone(corretor.getTelefone())
                        .creci(corretor.getCreci())
                        .status(corretor.getStatus())
                        .build()
                )
        .toList();
    }
}
