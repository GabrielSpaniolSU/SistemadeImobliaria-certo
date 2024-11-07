package com.example.sistemadeimobliaria.controller;

import com.example.sistemadeimobliaria.dto.ClienteDto;
import com.example.sistemadeimobliaria.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("SistemadeImobiliaria/Cliente")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cliente", description = "Operações para o cliente...")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos os clientes do banco de dados", description = "Busca todos os clientes do banco de dados e retorna em uma linha json")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<ClienteDto> getAllClientes() {
        log.info("Procura todos os clientes");
        return clienteService.getAllClientes();
    }
}


