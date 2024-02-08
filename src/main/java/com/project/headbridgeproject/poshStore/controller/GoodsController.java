package com.project.headbridgeproject.poshStore.controller;

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
    }



    /*private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodsEntity> getGoods(@RequestParam(value = "id") Long id) {
        GoodsEntity response = goodsService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodsEntity> getAllGoods() {
        return ResponseEntity.status(HttpStatus.OK)
                .body((GoodsEntity) goodsService.getAllGoods());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodsEntity> createGoods(@RequestBody GoodsEntity newGoods) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.create(newGoods));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodsEntity> updateGoods(@RequestBody GoodsEntity newGoods,
                                                   @RequestParam(value = "id") Long goodsId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(goodsService.update(newGoods, goodsId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGoods(@RequestParam(value = "id") Long id) {
        goodsService.delete(id);
    }*/
}
