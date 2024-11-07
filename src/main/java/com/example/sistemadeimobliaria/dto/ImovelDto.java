package com.example.sistemadeimobliaria.dto;

import com.example.sistemadeimobliaria.model.Contrato;
import com.example.sistemadeimobliaria.model.Proprietario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImovelDto {

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
