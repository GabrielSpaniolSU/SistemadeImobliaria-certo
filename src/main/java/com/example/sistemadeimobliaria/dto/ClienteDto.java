package com.example.sistemadeimobliaria.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String endereco;

    private String dataCadastro;

    private ContratoDto contrato;
}
