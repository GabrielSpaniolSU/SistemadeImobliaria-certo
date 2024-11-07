package com.example.sistemadeimobliaria.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorretorDto {

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String creci;

    private String status;
}
