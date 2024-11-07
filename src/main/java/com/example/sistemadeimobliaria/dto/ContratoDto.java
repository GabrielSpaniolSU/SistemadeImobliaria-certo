package com.example.sistemadeimobliaria.dto;

import com.example.sistemadeimobliaria.model.Cliente;
import com.example.sistemadeimobliaria.model.Imovel;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratoDto {

    private Date dataInicio;

    private Date dataFim;

    private Double valor;

    private String tipoContrato;

    private String status;

    private ClienteDto cliente;

    private ImovelDto imovel;
}
