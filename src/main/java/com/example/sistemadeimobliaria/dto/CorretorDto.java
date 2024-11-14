package com.example.sistemadeimobliaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorretorDto {

    @Schema(description = "Nome do corretor", example = "Pedro", title = "Nome corretor" )
    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String creci;

    private String status;
}
