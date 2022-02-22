package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    Stock create(StockDTO stock);
    void update(StockDTO stockDTO);
    Stock getStock(Long id);
    List<Stock> findAllStocksById();
    void deleteById(Long id);
}
