package com.raphaelrossi.cartservice.resources;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table(name="CART")
public class Cart implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="cartId")
    private Integer cartId;

    @ElementCollection
    @Column(name="product")
    private List<Product> products;
}
