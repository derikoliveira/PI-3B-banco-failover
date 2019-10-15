package br.usjt.Projeto.Integrado.B.model;

import javax.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double frete;
    private String dia;
    private String endereco;
    private String bairro;
    private String cpf;
}