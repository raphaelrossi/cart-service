package com.raphaelrossi.cartservice.repo;

import com.raphaelrossi.cartservice.resources.Cart;
import org.springframework.data.repository.CrudRepository;


public interface CartRepository extends CrudRepository<Cart, Integer>{
}
