package com.example.sistemadeimobliaria.dto;

import com.example.sistemadeimobliaria.model.Corretor;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Nome do proprietário", example = "Gabriel", title = "Nome do proprietário" )
    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String endereco;

    private CorretorDto corretor;
}
