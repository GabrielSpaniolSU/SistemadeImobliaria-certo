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

    @Schema(description = "Status do imóvel", example = "Disponível", title = "Status do imóvel" )
    private String status;

    @Schema(description = "Valor do imóvel", example = "'125,000,00 R$", title = "Valor do imóvel")
    private Double valor;

    @Schema(description = "Número de quartos do imóvel", example = "3", title = "Número de quartos do imóvel" )
    private Integer numeroQuartos;

    @Schema(description = "Número de banheiros do imóvel", example = "1", title = "Número de banheiro do imóvel" )
    private Integer numeroBanheiros;

    @Schema(description = "Área do imóvel", example = "200m²", title = "Área do imóvel" )
    private Integer area;

    @Schema(description = "Endereço do imóvel", example = "229", title = "Endereço do imóvel" )
    private String endereco;

    @Schema(description = "Contrato do imóvel", example = "3", title = "Contrato do imóvel" )
    private ContratoDto contrato;

    @Schema(description = "Proprietário do imóvel", example = "3", title = "Proprietário do imóvel" )
    private ProprietarioDto proprietario;
}
