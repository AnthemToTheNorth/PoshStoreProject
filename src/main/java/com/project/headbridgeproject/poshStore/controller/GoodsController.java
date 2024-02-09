package com.project.headbridgeproject.poshStore.controller;

import com.project.headbridgeproject.poshStore.dto.GoodsCreateDto;
import com.project.headbridgeproject.poshStore.dto.GoodsDto;
import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import com.project.headbridgeproject.poshStore.service.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {


    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsDto> getGoods(@PathVariable Long id) {
        GoodsDto response = goodsService.getOne(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<GoodsDto>> getAllGoods() {
        return ResponseEntity.ok(goodsService.getAllGoods());
    }

    @PostMapping
    public ResponseEntity<GoodsDto> createGoods(@RequestBody GoodsCreateDto newGoodsDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.create(newGoodsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsDto> updateGoods(@RequestBody GoodsCreateDto newGoodsDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.update(newGoodsDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    /*

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsEntity> getGoods(@PathVariable Long id) {
        GoodsEntity response = goodsService.getOne(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<GoodsEntity>> getAllGoods() {
        return ResponseEntity.ok(goodsService.getAllGoods());
    }

    @PostMapping("/{id}")
    public ResponseEntity<GoodsEntity> createGoods(@RequestBody GoodsEntity newGoods) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.create(newGoods));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsEntity> updateGoods(@RequestBody GoodsEntity newGoods, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.update(newGoods, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return ResponseEntity.noContent().build();
    }*/

}
