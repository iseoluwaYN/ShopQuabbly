package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.exception.StockException;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {

    @Autowired
    StockServiceImpl stockServiceImpl;
    @Autowired
    StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        stockRepository = null;
    }

    @Test
    void createStock(){
        StockDTO stock = new StockDTO();
        stock.setName("headset");
        stock.setCurrentPrice(12000.00);
        stockServiceImpl.create(stock);
        assertNotNull(stock);
    }

    @Test
    void stockDetailsCannotBeEmpty(){
        StockDTO stock = new StockDTO();
        assertThrows(StockException.class, () -> stockServiceImpl.create(stock));;
    }

    @Test
    void stockCanBeFoundById(){
//        create stock
        StockDTO stock = new StockDTO();
        stock.setName("headset");
        stock.setCurrentPrice(12000.00);

        Stock createdStock = stockServiceImpl.create(stock);
        assertNotNull(stock);

//        find stock
        assertNotNull(createdStock.getId());
    }

    @Test
    void testThatStockCanBeUpdated(){
        StockDTO stock = new StockDTO();
        stock.setName("headset");
        stock.setCurrentPrice(12000.00);

        Stock createdStock = stockServiceImpl.create(stock);
        assertNotNull(createdStock.getId());

        StockDTO updateStock = new StockDTO();
        updateStock.setCurrentPrice(12500.00);
        updateStock.setName("headset");
        Stock updatedStock = stockServiceImpl.update(createdStock.getId(), updateStock);
        assertThat( 12500.0).isEqualTo(updatedStock.getCurrentPrice());
    }

}