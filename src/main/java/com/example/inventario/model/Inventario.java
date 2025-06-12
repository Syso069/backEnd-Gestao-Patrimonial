package com.example.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "inventario")
@Entity(name = "inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_patrimonio", nullable = false)
    private Patrimonio patrimonio;

    @ManyToOne
    @JoinColumn(name = "fk_localizacao", nullable = false)
    private Localizacao localizacao;
}
