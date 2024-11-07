package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.ProprietarioDto;
import com.example.sistemadeimobliaria.repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public List<ProprietarioDto> getAllProprietarios() {
        return proprietarioRepository
                .findAll()
                .stream()
                .map(proprietario -> ProprietarioDto
                        .builder()
                        .nome(proprietario.getNome())
                        .cpf(proprietario.getCpf())
                        .email(proprietario.getEmail())
                        .telefone(proprietario.getTelefone())
                        .endereco(proprietario.getEndereco())
                        .build()
                )
        .toList();


    }

}