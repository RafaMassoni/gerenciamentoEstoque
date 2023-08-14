package br.com.estoque.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "deposito")
public class DepositoEntidade implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(nullable = false)
    @NotBlank(message = "Nome do depósito deve ser preenchido")
    private String nome;

}
