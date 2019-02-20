package com.raphaelrossi.cartservice.services;

import com.raphaelrossi.cartservice.exceptions.InvalidDataException;
import com.raphaelrossi.cartservice.repo.CartRepository;
import com.raphaelrossi.cartservice.resources.Cart;
import com.raphaelrossi.cartservice.resources.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Autowired
    private ProductServiceImpl productService;

    public void addProductToCart(Integer cartId, Product product){
        Cart cart = getCart(cartId);
        Product p = productService.getProduct(product.getId());
        cart.getProducts().add(p);
        cartRepository.save(cart);
    }

    public Cart getCart(Integer cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new InvalidDataException("Invalid cart id: " + cartId));
        return cart;
    }

    public Cart createCart(){
        return cartRepository.save(new Cart());
    }
}
