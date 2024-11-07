package com.example.sistemadeimobliaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "proprietario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;

    @OneToMany(mappedBy = "proprietario",
            targetEntity = Imovel.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Proprietario> proprietarios;
}
