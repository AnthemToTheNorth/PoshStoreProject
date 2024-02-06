package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;
    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Transactional(readOnly = true)
    public List<GoodsEntity> getAllGoods() {
        return goodsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GoodsEntity getOne(final Long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no product with this id "+ id));
    }

    @Transactional
    public GoodsEntity create(final GoodsEntity newGoods) {
        return goodsRepository.save(newGoods);
    }

    @Transactional
    public void delete(final Long id ) {
        goodsRepository.deleteById(id);
    }

    @Transactional
    public GoodsEntity update(final GoodsEntity newGoods, final Long id) {
        GoodsEntity existingGoods = getOne(id);
        existingGoods.setName(newGoods.getName());
        existingGoods.setBrand(newGoods.getBrand());
        existingGoods.setClassification(newGoods.getClassification());
        existingGoods.setSize(newGoods.getSize());
        existingGoods.setPrice(newGoods.getPrice());
        existingGoods.setDescription(newGoods.getDescription());
        return goodsRepository.save(existingGoods);
    }
}
