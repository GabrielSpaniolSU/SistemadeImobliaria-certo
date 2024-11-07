package com.example.sistemadeimobliaria.service;


import com.example.sistemadeimobliaria.dto.ContratoDto;
import com.example.sistemadeimobliaria.model.Contrato;
import com.example.sistemadeimobliaria.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
}
