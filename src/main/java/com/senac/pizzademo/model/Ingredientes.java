package com.senac.pizzademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Ingrediente;
    private Long Quantidade;

    public Long getId() {
        return this.id;
    }

    public String getIngrediente() {
        return this.Ingrediente;
    }

    public void setIngrediente(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public Long getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(Long Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Ingredientes(String Ingrediente, Long Quantidade, Pizza pizza) {
        this.Ingrediente = Ingrediente;
        this.Quantidade = Quantidade;
    }
    
    public Ingredientes() {
    }

}
