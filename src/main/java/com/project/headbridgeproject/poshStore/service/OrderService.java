package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.dto.*;
import com.project.headbridgeproject.poshStore.entity.CartOfOrderEntity;
import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import com.project.headbridgeproject.poshStore.entity.OrderEntity;
import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.CartOfOrderRepository;
import com.project.headbridgeproject.poshStore.repository.GoodsRepository;
import com.project.headbridgeproject.poshStore.repository.OrderRepository;
import com.project.headbridgeproject.poshStore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final GoodsRepository goodsRepository;
    private final CartOfOrderRepository cartOfOrderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, GoodsRepository goodsRepository, CartOfOrderRepository cartOfOrderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.goodsRepository = goodsRepository;
        this.cartOfOrderRepository = cartOfOrderRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertOrderEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDto getOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
        return convertOrderEntity(order);
    }

    @Transactional
    public OrderDto createOrder(OrderCreateDto orderCreateDto) {
        OrderEntity order = convertOrderCreateDto(orderCreateDto);
        return convertOrderEntity(orderRepository.save(order));
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private OrderDto convertOrderEntity(OrderEntity entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setComments(entity.getComments());
        orderDto.setDeliveryAddresses(entity.getDeliveryAddresses());
        orderDto.setUsers(convertUserEntity(entity.getUsers()));
        orderDto.setCartOfOrderEntity(convertCartOfOrderEntity(entity.getCartOfOrderEntity()));
        return orderDto;
    }

    private OrderEntity convertOrderCreateDto(OrderCreateDto orderCreateDto) {
        OrderEntity order = new OrderEntity();
        order.setComments(orderCreateDto.getComments());
        order.setDeliveryAddresses(orderCreateDto.getDeliveryAddresses());
        order.setUsers(userRepository.findById(orderCreateDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found")));
        order.setCartOfOrderEntity(cartOfOrderRepository.findById(orderCreateDto.getCartOfOrderId()).orElseThrow(() -> new NotFoundException("Cart of order not found")));
        return order;
    }

    private UserDto convertUserEntity(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setRole(entity.getRole());

        return userDto;
    }

    private CartOfOrderDto convertCartOfOrderEntity(CartOfOrderEntity entity) {
        CartOfOrderDto cartOfOrderDto = new CartOfOrderDto();
        cartOfOrderDto.setId(entity.getId());
        cartOfOrderDto.setGoods(convertGoodsEntities(entity.getGoods()));
        cartOfOrderDto.setOrders(convertOrderEntities(entity.getOrders()));
        cartOfOrderDto.setUserId(convertUserEntity(entity.getUserId()));
        return cartOfOrderDto;
    }

    private List<GoodsDto> convertGoodsEntities(List<GoodsEntity> goodsEntities) {
        return goodsEntities.stream()
                .map(this::convertGoodsEntity)
                .collect(Collectors.toList());
    }

    private GoodsDto convertGoodsEntity(GoodsEntity entity) {
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(entity.getId());
        goodsDto.setName(entity.getName());
        goodsDto.setDescription(entity.getDescription());
        goodsDto.setPrice(entity.getPrice());
        goodsDto.setSize(entity.getSize());
        goodsDto.setBrand(entity.getBrand());
        goodsDto.setClassification(entity.getClassification());
        return goodsDto;
    }

    private List<OrderDto> convertOrderEntities(List<OrderEntity> orderEntities) {
        return orderEntities.stream()
                .map(this::convertOrderEntity)
                .collect(Collectors.toList());
    }
}



    /*private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    @Transactional
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }*/



