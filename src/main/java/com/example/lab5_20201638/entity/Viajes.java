package com.example.lab5_20201638.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private Integer idViajes;

    @Column(name = "punto_recojo", nullable = false)
    private String punto_recojo;

    @Column(name = "cant_personas", nullable = false)
    private String cant_personas;

    @Column(name = "cant_perros", nullable = false)
    private String cant_perros;

    @Column(name = "Persona_idPersona", nullable = false)
    private String Persona_idPersona;

    @Column(name = "Lugares_idLugares", nullable = false)
    private String Lugares_idLugares;
}
