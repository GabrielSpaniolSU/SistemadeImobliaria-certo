package com.example.sistemadeimobliaria.controller;

import com.example.sistemadeimobliaria.dto.ContratoDto;
import com.example.sistemadeimobliaria.exception.ResourceNotFoundException;
import com.example.sistemadeimobliaria.model.Contrato;
import com.example.sistemadeimobliaria.service.ContratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contrato")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "contrato", description = "Operações para o contrato")
public class ContratoController {

    private final ContratoService contratoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all contrato from DB",
            description = "Fetches all contrato from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ContratoDto> getAllContratos() {
        log.info("Buscando todas as contratos");
        return contratoService.getAllContratos();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one cliente from DB",
            description = "Fetches one cliente from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<ContratoDto> getContratoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando contrato por id: {}", id);
        return ResponseEntity.ok().body(contratoService.getContratoById(id));
    }

    @PostMapping
    @Operation(summary = "Save cliente",
            description = "Save a cliente in database"
    )
    public Contrato createContrato(@RequestBody ContratoDto contratoDto) throws ResourceNotFoundException {
        log.info("Cadastro contrato: {}", contratoDto);
        return contratoService.saveContrato(contratoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cliente",
            description = "Update a cliente in database"
    )
    public ResponseEntity<ContratoDto> updateContrato(@PathVariable(name = "id") Long id, @RequestBody ContratoDto contratoDto) throws ResourceNotFoundException {
        log.info("Atualizando contrato: {}", contratoDto);
        return ResponseEntity.ok(contratoService.contratoEdit(id, contratoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cliente",
            description = "Remove a cliente in database"
    )
    public Map<String, Boolean> deleteContrato(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando contrato: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", contratoService.deleteContrato(id));
        return response;
    }
}
