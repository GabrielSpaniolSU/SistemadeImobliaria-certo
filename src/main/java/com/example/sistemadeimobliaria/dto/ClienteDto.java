package com.example.sistemadeimobliaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    @Schema(description = "Nome da pessoa", example = "João", title = "nome" )
    private String nome;

    @Schema(description = "Cpf do cliente", example = "123.545.643-51", title = "CPF" )
    private String cpf;

    private String email;

    private String telefone;

    private String endereco;

    private String dataCadastro;

    private ContratoDto contrato;
}
