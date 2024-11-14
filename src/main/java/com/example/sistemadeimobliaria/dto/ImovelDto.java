package com.example.sistemadeimobliaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImovelDto {

    @Schema(description = "Tipo do imóvel", example = "Casa", title = "Tipo do imóvel" )
    private String tipo;

    private String status;

    private Double valor;

    private Integer numeroQuartos;

    private Integer numeroBanheiros;

    private Integer area;

    private String endereco;

    private ContratoDto contrato;

    private ProprietarioDto proprietario;
}
