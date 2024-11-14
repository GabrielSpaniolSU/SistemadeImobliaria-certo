package com.example.sistemadeimobliaria.service;


import com.example.sistemadeimobliaria.dto.ClienteDto;
import com.example.sistemadeimobliaria.dto.ContratoDto;
import com.example.sistemadeimobliaria.model.Cliente;
import com.example.sistemadeimobliaria.model.Contrato;
import com.example.sistemadeimobliaria.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<ContratoDto> getAllContratos() {
        return contratoRepository
                .findAll()
                .stream()
                .map(contrato -> ContratoDto
                        .builder()
                        .dataInicio(contrato.getDataInicio())
                        .dataFim(contrato.getDataFim())
                        .valor(contrato.getValor())
                        .tipoContrato(contrato.getTipoContrato())
                        .status(contrato.getStatus())
                        .build()
                )
                .toList();
    }

    public ContratoDto getContratoById(Long id) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow();
        return new ContratoDto()
                .builder()
                .dataInicio(contrato.getDataInicio())
                .dataFim(contrato.getDataFim())
                .valor(contrato.getValor())
                .tipoContrato(contrato.getTipoContrato())
                .status(contrato.getStatus())
                .build();
    }

    public Contrato saveContrato(ContratoDto contratoDto) {
        Contrato contrato = new Contrato();
        contrato.setDataInicio(contratoDto.getDataInicio());
        contrato.setDataFim(contratoDto.getDataFim());
        contrato.setValor(contratoDto.getValor());
        contrato.setTipoContrato(contratoDto.getTipoContrato());
        contrato.setStatus(contratoDto.getStatus());
        return contratoRepository.save(contrato);

    }

    public ContratoDto contratoEdit(Long id, ContratoDto contratoDto) {
        Contrato contrato = contratoRepository.findById(id).orElseThrow();
        contrato.setDataInicio(contratoDto.getDataInicio());
        contrato.setDataFim(contratoDto.getDataFim());
        contrato.setValor(contratoDto.getValor());
        contrato.setTipoContrato(contratoDto.getTipoContrato());
        contrato.setStatus(contratoDto.getStatus());
        Contrato contratoEditado = contratoRepository.save(contrato);
        return new ContratoDto()
                .builder()
                .dataInicio(contratoEditado.getDataInicio())
                .dataFim(contratoEditado.getDataFim())
                .valor(contratoEditado.getValor())
                .tipoContrato(contratoEditado.getTipoContrato())
                .status(contratoEditado.getStatus())
                .build();

    }

    public boolean deleteContrato(Long id){
        try {
            Contrato contrato = contratoRepository.findById(id).orElseThrow();
            contratoRepository.delete(contrato);
            return true;
        } catch (Exception e) {
            return false;
        }

    }}





