package com.example.sistemadeimobliaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "imovel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //tipo= se é uma casa, apartamento, etc
    @Column(name = "tipo", length = 150)
    private String tipo;

    @Column(name = "status", length = 150)
    private String status;

    @Column(name = "valor", length = 150)
    private Double valor;

    @Column(name = "numeroQuartos", length = 150)
    private Integer numeroQuartos;

    @Column(name = "numeroBanheiros", length = 150)
    private Integer numeroBanheiros;

    @Column(name = "area", length = 150)
    private Integer area;

    @Column(name = "endereco", length = 150)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @OneToMany(mappedBy = "imovel",
            targetEntity = Contrato.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Imovel> imovels;



}
