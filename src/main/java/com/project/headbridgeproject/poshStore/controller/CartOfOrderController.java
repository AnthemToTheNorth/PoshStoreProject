package com.project.headbridgeproject.poshStore.controller;


import com.project.headbridgeproject.poshStore.entity.CartOfOrderEntity;
import com.project.headbridgeproject.poshStore.service.CartOfOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartOfOrderController {
    private final CartOfOrderService cartOfOrderService;

    public CartOfOrderController(CartOfOrderService cartOfOrderService) {
        this.cartOfOrderService = cartOfOrderService;
    }

    @GetMapping
    public List<CartOfOrderEntity> getAllCarts() {
        return cartOfOrderService.getAllCarts();
    }

    @GetMapping("/{id}")
    public CartOfOrderEntity getCartById(@PathVariable Long id) {
        return cartOfOrderService.getCartById(id);
    }

    @PostMapping
    public CartOfOrderEntity createCart(@RequestBody CartOfOrderEntity cart) {
        return cartOfOrderService.createCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartOfOrderService.deleteCart(id);
    }

    @PutMapping("/{cartId}/goods/{goodsId}")
    public void addGoodsToCart(@PathVariable Long cartId, @PathVariable Long goodsId) {
        cartOfOrderService.addGoodsToCart(cartId, goodsId);
    }

    @DeleteMapping("/{cartId}/goods/{goodsId}")
    public void removeGoodsFromCart(@PathVariable Long cartId, @PathVariable Long goodsId) {
        cartOfOrderService.removeGoodsFromCart(cartId, goodsId);
    }
}
