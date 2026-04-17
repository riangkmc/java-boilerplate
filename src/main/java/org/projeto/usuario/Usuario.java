package org.projeto.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    private String nome;
}
