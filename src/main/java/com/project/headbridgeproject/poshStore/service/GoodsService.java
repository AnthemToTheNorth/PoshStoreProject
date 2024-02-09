package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.dto.GoodsCreateDto;
import com.project.headbridgeproject.poshStore.dto.GoodsDto;
import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;
    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Transactional(readOnly = true)
    public List<GoodsDto> getAllGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        return goodsEntities.stream()
                .map(goodsEntity -> GoodsDto.builder()
                        .id(goodsEntity.getId())
                        .name(goodsEntity.getName())
                        .description(goodsEntity.getDescription())
                        .price(goodsEntity.getPrice())
                        .size(goodsEntity.getSize())
                        .brand(goodsEntity.getBrand())
                        .classification(goodsEntity.getClassification())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GoodsDto getOne(final Long id) {
        GoodsEntity goodsEntity = goodsRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no product with this id "+ id));
        return GoodsDto.builder()
                .id(goodsEntity.getId())
                .name(goodsEntity.getName())
                .description(goodsEntity.getDescription())
                .price(goodsEntity.getPrice())
                .size(goodsEntity.getSize())
                .brand(goodsEntity.getBrand())
                .classification(goodsEntity.getClassification())
                .build();
    }

    @Transactional
    public GoodsDto create(final GoodsCreateDto newGoodsDto) {
        GoodsEntity newGoods = GoodsEntity.builder()
                .name(newGoodsDto.getName())
                .description(newGoodsDto.getDescription())
                .price(newGoodsDto.getPrice())
                .size(newGoodsDto.getSize())
                .brand(newGoodsDto.getBrand())
                .classification(newGoodsDto.getClassification())
                .build();
        return GoodsDto.builder()
                .id(goodsRepository.save(newGoods).getId())
                .name(newGoods.getName())
                .description(newGoods.getDescription())
                .price(newGoods.getPrice())
                .size(newGoods.getSize())
                .brand(newGoods.getBrand())
                .classification(newGoods.getClassification())
                .build();
    }

    @Transactional
    public GoodsDto update(final GoodsCreateDto newGoodsDto, final Long id) {
        GoodsEntity existingGoods = goodsRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no product with this id "+ id));
        existingGoods.setName(newGoodsDto.getName());
        existingGoods.setBrand(newGoodsDto.getBrand());
        existingGoods.setClassification(newGoodsDto.getClassification());
        existingGoods.setSize(newGoodsDto.getSize());
        existingGoods.setPrice(newGoodsDto.getPrice());
        existingGoods.setDescription(newGoodsDto.getDescription());
        return GoodsDto.builder()
                .id(goodsRepository.save(existingGoods).getId())
                .name(existingGoods.getName())
                .description(existingGoods.getDescription())
                .price(existingGoods.getPrice())
                .size(existingGoods.getSize())
                .brand(existingGoods.getBrand())
                .classification(existingGoods.getClassification())
                .build();
    }

    @Transactional
    public void delete(final Long id ) {
        goodsRepository.deleteById(id);
    }



    /*
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
    }*/

}
