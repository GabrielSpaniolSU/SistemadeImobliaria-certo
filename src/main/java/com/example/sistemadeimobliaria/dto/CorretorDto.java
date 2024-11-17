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

    @Schema(description = "CPF do corretor", example = "134.544.232-42", title = "CPF do corretor" )
    private String cpf;

    @Schema(description = "Email do cliente", example = "juaupaulu@gmail.com", title = "Email do cliente" )
    private String email;

    @Schema(description = "Telefone do corretor", example = "(46)999543129", title = "Telefone do corretor" )
    private String telefone;

    @Schema(description = "Creci do corretor", example = "12345, F, SP", title = "Creci do corretor" )
    private String creci;

    @Schema(description = "Status do corretor", example = "Ativo", title = "Status do corretor" )
    private String status;
}
