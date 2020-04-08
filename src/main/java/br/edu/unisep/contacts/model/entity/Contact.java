package br.edu.unisep.contacts.model.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contats")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Integer id;

    private  String nome;

    private String email;

}
