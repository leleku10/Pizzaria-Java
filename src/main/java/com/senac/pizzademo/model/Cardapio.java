package com.senac.pizzademo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Float valor;
    private String tamanho;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cardapio")
    @JsonBackReference
    private List<Pizza> pizzas;

    public Long getId() {
        return this.id;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Cardapio(Float valor, String tamanho, List<Pizza> pizzas) {        
        this.valor = valor;
        this.tamanho = tamanho;
        this.pizzas = pizzas;
    }

    public Cardapio() {
    }
}
