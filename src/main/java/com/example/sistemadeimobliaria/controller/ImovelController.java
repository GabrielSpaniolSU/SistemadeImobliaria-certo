package com.example.sistemadeimobliaria.controller;

import com.example.sistemadeimobliaria.dto.ImovelDto;
import com.example.sistemadeimobliaria.exception.ResourceNotFoundException;
import com.example.sistemadeimobliaria.model.Imovel;
import com.example.sistemadeimobliaria.service.ImovelService;
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
@RequestMapping("/api/imovel")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Imovel", description = "Operações para o Imóvel")
public class ImovelController {

    private final ImovelService imovelService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all imovel from DB",
            description = "Fetches all imovel from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ImovelDto> getAllImovels() {
        log.info("Buscando todas as imovels");
        return imovelService.getAllImovels();
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
    public ResponseEntity<ImovelDto> getImovelById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando imovel por id: {}", id);
        return ResponseEntity.ok().body(imovelService.getImovelById(id));
    }

    @PostMapping
    @Operation(summary = "Save cliente",
            description = "Save a cliente in database"
    )
    public Imovel createImovel(@RequestBody ImovelDto imovelDto) throws ResourceNotFoundException {
        log.info("Cadastro imovel: {}", imovelDto);
        return imovelService.saveImovel(imovelDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cliente",
            description = "Update a cliente in database"
    )
    public ResponseEntity<ImovelDto> updateImovel(@PathVariable(name = "id") Long id, @RequestBody ImovelDto imovelDto) throws ResourceNotFoundException {
        log.info("Atualizando imovel: {}", imovelDto);
        return ResponseEntity.ok(imovelService.imovelDto(id, imovelDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cliente",
            description = "Remove a cliente in database"
    )
    public Map<String, Boolean> deleteImovel(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando imovel: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", imovelService.deleteImovel(id));
        return response;
    }
}
