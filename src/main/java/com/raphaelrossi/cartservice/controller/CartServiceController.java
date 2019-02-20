package com.raphaelrossi.cartservice.controller;

import com.raphaelrossi.cartservice.resources.Cart;
import com.raphaelrossi.cartservice.resources.Product;
import com.raphaelrossi.cartservice.services.CartServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@Api(value = "cartservice", description = "Data service operations on carts", tags=("carts"))
public class CartServiceController {
    @Autowired
    CartServiceImpl cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/carts")
    @ApiOperation(value="Create a Cart", notes = "Create an empty cart", nickname = "postCart")
    public Cart createCart(){
        return cartService.createCart();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{CART_ID}")
    @ApiOperation(value="Get a Cart", notes = "Get cart content by id", nickname = "getCart")
    public Cart getCart(@PathVariable(value = "CART_ID") Integer cartId){
        return cartService.getCart(cartId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts/{id}/products")
    @ApiOperation(value="Add Product to Cart", notes = "Add a product to a cart", nickname = "postProductToCart")
    public Cart addProductsCart(@PathVariable(value = "id") int cartId, @RequestBody Product product){
        cartService.addProductToCart(cartId, product);
        return cartService.getCart(cartId);
    }
}
