package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.ContratoDto;
import com.example.sistemadeimobliaria.dto.CorretorDto;
import com.example.sistemadeimobliaria.model.Contrato;
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

    public CorretorDto getCorretorById(Long id) {
        Corretor corretor = corretorRepository.findById(id).orElseThrow();
        return new CorretorDto()
                .builder()
                .nome(corretor.getNome())
                .cpf(corretor.getCpf())
                .email(corretor.getEmail())
                .telefone(corretor.getTelefone())
                .creci(corretor.getCreci())
                .status(corretor.getStatus())
                .build();

    }

    public Corretor saveCorretor(CorretorDto corretorDto) {
        Corretor corretor= new Corretor();
        corretor.setNome(corretorDto.getNome());
        corretor.setCpf(corretorDto.getCpf());
        corretor.setEmail(corretorDto.getEmail());
        corretor.setTelefone(corretorDto.getTelefone());
        corretor.setCreci(corretorDto.getCreci());
        return corretorRepository.save(corretor);

    }

    public CorretorDto corretorEdit(Long id, CorretorDto corretorDto) {
        Corretor corretor = corretorRepository.findById(id).orElseThrow();
        corretor.setNome(corretorDto.getNome());
        corretor.setCpf(corretorDto.getCpf());
        corretor.setEmail(corretorDto.getEmail());
        corretor.setTelefone(corretorDto.getTelefone());
        corretor.setCreci(corretorDto.getCreci());
        corretor.setStatus(corretorDto.getStatus());
        Corretor corretorEditado = corretorRepository.save(corretor);
        return new CorretorDto()
                .builder()
                .nome(corretorEditado.getNome())
                .cpf(corretorEditado.getCpf())
                .email(corretorEditado.getEmail())
                .telefone(corretorEditado.getTelefone())
                .creci(corretorEditado.getCreci())
                .status(corretorEditado.getStatus())
                .build();

    }

    public boolean deleteCorretor(Long id){
        try {
            Corretor corretor = corretorRepository.findById(id).orElseThrow();
            corretorRepository.delete(corretor);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}

