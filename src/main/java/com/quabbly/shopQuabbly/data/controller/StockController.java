package com.quabbly.shopQuabbly.data.controller;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    StockService stockServiceImpl;

    @PostMapping("/")
    public Stock createStock (@RequestBody StockDTO stockDTO){
        return stockServiceImpl.create(stockDTO);
    }
    @GetMapping("/")
    public List<Stock> getAllStocks(){
        return stockServiceImpl.findAllStocks();
    }
    @GetMapping("/{id}/")
    public Stock getById(@PathVariable Long id) {
        return stockServiceImpl.getStock(id);
    }
    @DeleteMapping("/{id}/")
    public void deleteStock(@PathVariable Long id){
        stockServiceImpl.deleteById(id);
    }
    @PutMapping("/")
    public Stock updateStock(@PathVariable Long id, @RequestBody StockDTO stockDTO){
        return stockServiceImpl.update(id, stockDTO);
    }
}
