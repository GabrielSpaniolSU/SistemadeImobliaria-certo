package com.example.sistemadeimobliaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "corretor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Corretor  {

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

    //creci= registro profissional do corretor
    @Column(name = "creci", length = 150)
    private String creci;

    @Column(name = "status", length = 150)
    private String status;

    @OneToMany(mappedBy = "corretor",
            targetEntity = Proprietario.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Corretor> corretors;
}
