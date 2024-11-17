package com.example.sistemadeimobliaria.dto;

import com.example.sistemadeimobliaria.model.Cliente;
import com.example.sistemadeimobliaria.model.Imovel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratoDto {


    @Schema(description = "Data do contrato", example = "15/12/2006", title = "Data do contrato" )
    private Date dataInicio;

    @Schema(description = "Data do fim do Contrato", example = "13/11/2020", title = "Data do fim do contrato" )
    private Date dataFim;

    @Schema(description = "Valor do imóvel", example = "130,00 R$", title = "Valor do imóvel" )
    private Double valor;

    @Schema(description = "Tipo de contrato", example = "Contrato por tempo indeterminado", title = "Tipo de contrato" )
    private String tipoContrato;

    @Schema(description = "Status do contrato", example = "preliminar", title = "Status do Contrato" )
    private String status;

    @Schema(description = "Valor do imóvel", example = "130,00 R$", title = "Valor do imóvel" )
    private ClienteDto cliente;

    @Schema(description = "Imóvel", example = "Casa", title = "Imóvel" )
    private ImovelDto imovel;
}
