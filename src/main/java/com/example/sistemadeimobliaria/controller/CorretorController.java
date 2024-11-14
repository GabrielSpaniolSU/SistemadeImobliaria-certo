package com.example.sistemadeimobliaria.controller;

import com.example.sistemadeimobliaria.dto.CorretorDto;
import com.example.sistemadeimobliaria.exception.ResourceNotFoundException;
import com.example.sistemadeimobliaria.model.Corretor;
import com.example.sistemadeimobliaria.service.CorretorService;
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
@RequestMapping("/api/corretor")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Corretor", description = "Operações para o Corretor" )
public class CorretorController {

    private final CorretorService corretorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all corretor from DB",
            description = "Fetches all corretor from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<CorretorDto> getAllCorretors() {
        log.info("Buscando todas as corretors");
        return corretorService.getAllCorretors();
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
    public ResponseEntity<CorretorDto> getCorretorById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando corretor por id: {}", id);
        return ResponseEntity.ok().body(corretorService.getCorretorById(id));
    }

    @PostMapping
    @Operation(summary = "Save cliente",
            description = "Save a cliente in database"
    )
    public Corretor createCorretor(@RequestBody CorretorDto corretorDto) throws ResourceNotFoundException {
        log.info("Cadastro corretor: {}", corretorDto);
        return corretorService.saveCorretor(corretorDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cliente",
            description = "Update a cliente in database"
    )
    public ResponseEntity<CorretorDto> updateCorretor(@PathVariable(name = "id") Long id, @RequestBody CorretorDto corretorDto) throws ResourceNotFoundException {
        log.info("Atualizando corretor: {}", corretorDto);
        return ResponseEntity.ok(corretorService.corretorEdit(id, corretorDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cliente",
            description = "Remove a cliente in database"
    )
    public Map<String, Boolean> deleteCorretor(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando corretor: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", corretorService.deleteCorretor(id));
        return response;
    }
}
