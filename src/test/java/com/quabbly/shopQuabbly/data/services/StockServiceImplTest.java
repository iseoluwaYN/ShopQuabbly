package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class StockServiceImplTest {

    @Autowired
    StockServiceImpl stockServiceImpl;
    @Autowired
    StockRepository stockRepository;

    @BeforeEach
    void setUp() {
//        stockRepository.deleteAll();
    }

    @Test
    void createStock(){
        StockDTO stock = new StockDTO();
        stock.setName("headset");
        stock.setCurrentPrice(12000.00);
        stockServiceImpl.create(stock);
        assertNotNull(stock);
    }

//    @Test
//    void
}