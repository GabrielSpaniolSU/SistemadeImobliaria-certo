package com.example.sistemadeimobliaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //strategy significa q vai gerar dados em sequência a partir do id
    //length é o número máximo de caractéres na varíavel

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "cpf", length = 150)
    private String cpf;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "telefone", length = 150)
    private String telefone;

    @Column(name = "endereço", length = 150)
    private String endereco;

    @Column(name = "dataCadastro", length = 150)
    private String dataCadastro;

    @OneToMany(mappedBy = "cliente",
            targetEntity = Contrato.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cliente> clientes;
}
