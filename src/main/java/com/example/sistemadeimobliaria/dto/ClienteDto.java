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

    @Schema(description = "Email do Cliente", example = "joaopaulu@gmail.com", title = "Email" )
    private String email;

    @Schema(description = "Telefone do cliente", example = "(46)99740829", title = "Telefone" )
    private String telefone;

    @Schema(description = "Endereço do cliente", example = "229", title = "Endereço" )
    private String endereco;

    @Schema(description = "Data de cadastro do cliente", example = "15/10/2007", title = "Data de Cadastro")
    private String dataCadastro;

    @Schema(description = "Contrato do cliente", example = "56°", title = "Contrato" )
    private ContratoDto contrato;
}
