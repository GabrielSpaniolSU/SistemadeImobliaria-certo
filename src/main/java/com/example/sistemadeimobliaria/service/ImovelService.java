package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.ImovelDto;
import com.example.sistemadeimobliaria.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<ImovelDto> getAllImovels() {
        return imovelRepository
                .findAll()
                .stream()
                .map(imovel -> ImovelDto
                        .builder()
                        .tipo(imovel.getTipo())
                        .status(imovel.getStatus())
                        .valor(imovel.getValor())
                        .numeroQuartos(imovel.getNumeroQuartos())
                        .numeroBanheiros(imovel.getNumeroBanheiros())
                        .area(imovel.getArea())
                        .endereco(imovel.getEndereco())
                        .build()
                )
        .toList();
    }
}
