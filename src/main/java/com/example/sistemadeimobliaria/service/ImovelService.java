package com.example.sistemadeimobliaria.service;

import com.example.sistemadeimobliaria.dto.CorretorDto;
import com.example.sistemadeimobliaria.dto.ImovelDto;
import com.example.sistemadeimobliaria.model.Corretor;
import com.example.sistemadeimobliaria.model.Imovel;
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

    public ImovelDto getImovelById(Long id) {
        Imovel imovel = imovelRepository.findById(id).orElseThrow();
        return new ImovelDto()
                .builder()
                .tipo(imovel.getTipo())
                .status(imovel.getStatus())
                .valor(imovel.getValor())
                .numeroQuartos(imovel.getNumeroQuartos())
                .numeroBanheiros(imovel.getNumeroBanheiros())
                .area(imovel.getArea())
                .endereco(imovel.getEndereco())
                .build();

    }

    public Imovel saveImovel(ImovelDto imovelDto) {
        Imovel imovel= new Imovel();
        imovel.setTipo(imovelDto.getTipo());
        imovel.setStatus(imovelDto.getStatus());
        imovel.setValor(imovelDto.getValor());
        imovel.setNumeroQuartos(imovelDto.getNumeroQuartos());
        imovel.setNumeroBanheiros(imovelDto.getNumeroBanheiros());
        imovel.setArea(imovelDto.getArea());
        imovel.setEndereco(imovelDto.getEndereco());
        return imovelRepository.save(imovel);

    }

    public ImovelDto imovelDto(Long id, ImovelDto imovelDto) {
        Imovel imovel = imovelRepository.findById(id).orElseThrow();
        imovel.setTipo(imovelDto.getTipo());
        imovel.setStatus(imovelDto.getStatus());
        imovel.setValor(imovelDto.getValor());
        imovel.setNumeroQuartos(imovelDto.getNumeroQuartos());
        imovel.setNumeroBanheiros(imovelDto.getNumeroBanheiros());
        imovel.setArea(imovelDto.getArea());
        imovel.setEndereco(imovelDto.getEndereco());
        Imovel imovelEditado = imovelRepository.save(imovel);
        return new ImovelDto()
                .builder()
                .tipo(imovelEditado.getTipo())
                .status(imovelEditado.getStatus())
                .valor(imovelEditado.getValor())
                .numeroQuartos(imovelEditado.getNumeroQuartos())
                .numeroBanheiros(imovelEditado.getNumeroBanheiros())
                .area(imovelEditado.getArea())
                .endereco(imovelEditado.getEndereco())
                .build();

    }

    public boolean deleteImovel(Long id) {
        try {
            Imovel imovel = imovelRepository.findById(id).orElseThrow();
            imovelRepository.delete(imovel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }}

