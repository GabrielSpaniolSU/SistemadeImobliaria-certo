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

    private Date dataFim;

    private Double valor;

    private String tipoContrato;

    private String status;

    private ClienteDto cliente;

    private ImovelDto imovel;
}
