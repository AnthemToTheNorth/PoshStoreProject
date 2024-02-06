package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.entity.CartOfOrderEntity;
import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.CartOfOrderRepository;
import com.project.headbridgeproject.poshStore.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartOfOrderService {

    private final GoodsRepository goodsRepository;
    private final CartOfOrderRepository cartOfOrderRepository;

    public CartOfOrderService(GoodsRepository goodsRepository, CartOfOrderRepository cartOfOrderRepository) {
        this.goodsRepository = goodsRepository;
        this.cartOfOrderRepository = cartOfOrderRepository;
    }

    @Transactional(readOnly = true)
    public List<CartOfOrderEntity> getAllCarts() {
        return cartOfOrderRepository.findAll();
    }

    @Transactional
    public CartOfOrderEntity getCartById(Long id) {
        return cartOfOrderRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart not found"));
    }

    @Transactional
    public CartOfOrderEntity createCart(CartOfOrderEntity cart) {
        return cartOfOrderRepository.save(cart);
    }

    @Transactional
    public void deleteCart(Long id) {
        cartOfOrderRepository.deleteById(id);
    }

    @Transactional
    public void addGoodsToCart(Long cartId, Long goodsId) {
        CartOfOrderEntity cart = cartOfOrderRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        GoodsEntity goods = goodsRepository.findById(goodsId).orElseThrow(() -> new NotFoundException("Goods not found"));
        cart.getGoodsId().add(goods);
        cartOfOrderRepository.save(cart);
    }

    @Transactional
    public void removeGoodsFromCart(Long cartId, Long goodsId) {
        CartOfOrderEntity cart = cartOfOrderRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        GoodsEntity goods = goodsRepository.findById(goodsId).orElseThrow(() -> new NotFoundException("Goods not found"));
        if (cart.getGoodsId().contains(goods)) {
            cart.getGoodsId().remove(goods);
            cartOfOrderRepository.save(cart);
        } else {
            throw new NotFoundException("Goods not found in cart");
        }
    }

}
