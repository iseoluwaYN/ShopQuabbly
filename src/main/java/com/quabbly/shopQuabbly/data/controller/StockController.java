package com.quabbly.shopQuabbly.data.controller;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.exception.StockException;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    StockService stockServiceImpl;

    @PostMapping("/")
    public ResponseEntity<?> createStock (@RequestBody StockDTO stockDTO){
        try {
            return new ResponseEntity<>(stockServiceImpl.create(stockDTO), HttpStatus.OK);
        }
        catch (StockException stockException){
            log.info("Error -> {}", stockException.getMessage());
            return new ResponseEntity<>(stockException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllStocks(){
        try {
            return new ResponseEntity<>(stockServiceImpl.findAllStocks(), HttpStatus.OK);
        }
        catch (StockException stockException){
            log.info("Error -> {}", stockException.getMessage());
            return new ResponseEntity<>(stockException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(stockServiceImpl.getStock(id), HttpStatus.OK);
        }
        catch (StockException stockException){
            log.info("Error -> {}", stockException.getMessage());
            return new ResponseEntity<>(stockException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> deleteStock(@PathVariable Long id){
        stockServiceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody StockDTO stockDTO){
        try {
            return new ResponseEntity<>(stockServiceImpl.update(id, stockDTO), HttpStatus.OK);
        } catch (StockException stockException){
            log.info("Error -> {}", stockException.getMessage());
            return new ResponseEntity<>(stockException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
