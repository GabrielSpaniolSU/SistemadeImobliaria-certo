package com.example.sistemadeimobliaria.controller;

import com.example.sistemadeimobliaria.dto.ProprietarioDto;
import com.example.sistemadeimobliaria.exception.ResourceNotFoundException;
import com.example.sistemadeimobliaria.model.Proprietario;
import com.example.sistemadeimobliaria.service.ProprietarioService;
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
@RequestMapping("/api/proprietario")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Proprietario", description = "Operações para o Proprietario")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all proprietario from DB",
            description = "Fetches all proprietario from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ProprietarioDto> getAllProprietarios() {
        log.info("Buscando todas as proprietarios");
        return proprietarioService.getAllProprietarios();
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
    public ResponseEntity<ProprietarioDto> getProprietarioById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando proprietario por id: {}", id);
        return ResponseEntity.ok().body(proprietarioService.getProprietarioById(id));
    }

    @PostMapping
    @Operation(summary = "Save cliente",
            description = "Save a cliente in database"
    )
    public Proprietario createProprietario(@RequestBody ProprietarioDto proprietarioDto) throws ResourceNotFoundException {
        log.info("Cadastro proprietario: {}", proprietarioDto);
        return proprietarioService.saveProprietario(proprietarioDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cliente",
            description = "Update a cliente in database"
    )
    public ResponseEntity<ProprietarioDto> updateProprietario(@PathVariable(name = "id") Long id, @RequestBody ProprietarioDto proprietarioDto) throws ResourceNotFoundException {
        log.info("Atualizando proprietario: {}", proprietarioDto);
        return ResponseEntity.ok(proprietarioService.proprietarioDto(id, proprietarioDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cliente",
            description = "Remove a cliente in database"
    )
    public Map<String, Boolean> deleteProprietario(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando proprietario: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", proprietarioService.deleteProprietario(id));
        return response;
    }
}
