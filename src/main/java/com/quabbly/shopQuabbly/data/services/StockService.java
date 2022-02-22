package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.model.Stock;

public interface StockService {
    void create(Stock stock);
    void update(StockDTO stockDTO);
    Stock getStock(String id);
    Stock findAllStocksById();
    void deleteById(String id);
}
