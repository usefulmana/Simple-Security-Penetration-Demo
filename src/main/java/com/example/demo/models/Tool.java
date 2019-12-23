package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tools")
@Data
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "isVisible")
    private boolean isVisible = true;

    public Tool(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


}
