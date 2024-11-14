package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.ImovelDto;
import com.example.sistemadeimobliaria.dto.ProprietarioDto;
import com.example.sistemadeimobliaria.model.Imovel;
import com.example.sistemadeimobliaria.model.Proprietario;
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

    public ProprietarioDto getProprietarioById(Long id) {
        Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow();
        return new ProprietarioDto()
                .builder()
                .nome(proprietario.getNome())
                .cpf(proprietario.getCpf())
                .email(proprietario.getEmail())
                .telefone(proprietario.getTelefone())
                .endereco(proprietario.getEndereco())
                .build();

    }

    public Proprietario saveProprietario(ProprietarioDto proprietarioDto) {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(proprietarioDto.getNome());
        proprietario.setCpf(proprietarioDto.getCpf());
        proprietario.setEmail(proprietarioDto.getEmail());
        proprietario.setTelefone(proprietarioDto.getTelefone());
        proprietario.setEndereco(proprietarioDto.getEndereco());
        return proprietarioRepository.save(proprietario);

    }

    public ProprietarioDto proprietarioDto(Long id, ProprietarioDto proprietarioDto) {
        Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow();
        proprietario.setNome(proprietarioDto.getNome());
        proprietario.setCpf(proprietarioDto.getCpf());
        proprietario.setEmail(proprietarioDto.getEmail());
        proprietario.setTelefone(proprietarioDto.getTelefone());
        proprietario.setEndereco(proprietarioDto.getEndereco());
        return new ProprietarioDto()
                .builder()
                .nome(proprietario.getNome())
                .cpf(proprietario.getCpf())
                .email(proprietario.getEmail())
                .telefone(proprietario.getTelefone())
                .endereco(proprietario.getEndereco())
                .build();

    }

    public boolean deleteProprietario(Long id) {
        try {
            Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow();
            proprietarioRepository.delete(proprietario);
            return true;
        } catch (Exception e) {
            return false;
        }


}}