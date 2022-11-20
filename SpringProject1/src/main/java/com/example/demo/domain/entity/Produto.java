package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" )
    private Integer ID;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "PRECO_UNITARIO")
    private BigDecimal precoUnitario;


    @Override
    public String toString() {
        return "Produto{" +
                "ID=" + ID +
                ", descrição='" + descricao + '\'' +
                ", preço=" + precoUnitario +
                '}';
    }
}
