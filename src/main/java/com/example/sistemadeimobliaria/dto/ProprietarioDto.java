package com.example.sistemadeimobliaria.dto;

import com.example.sistemadeimobliaria.model.Corretor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProprietarioDto {

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String endereco;

    private CorretorDto corretor;
}
