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

    @Schema(description = "Nome do proprietário", example = "132.432.543-32", title = "Nome do proprietário" )
    private String cpf;

    @Schema(description = "Email do proprietário", example = "gabrielspaniol@gmail.com", title = "Email do proprietário" )
    private String email;

    @Schema(description = "Telefone do proprietário", example = "(46)888128489", title = "Telefone do proprietário" )
    private String telefone;

    @Schema(description = "Endereço do proprietário", example = "243", title = "Enedereço do proprietário" )
    private String endereco;

    @Schema(description = "Corretor do proprietário", example = "Luan", title = "Corretor do proprietário" )
    private CorretorDto corretor;
}
