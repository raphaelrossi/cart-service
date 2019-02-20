package com.raphaelrossi.cartservice.services;

import com.raphaelrossi.cartservice.resources.Cart;
import com.raphaelrossi.cartservice.resources.Product;

import java.util.Optional;


public interface CartService {
    void addProductToCart(Integer cartId, Product product);
    Cart getCart(Integer cartId);
    Cart createCart();
}
