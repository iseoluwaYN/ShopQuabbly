package com.quabbly.shopQuabbly.data.controller;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RestController("/api/v1/stocks")
public class StockController {

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
