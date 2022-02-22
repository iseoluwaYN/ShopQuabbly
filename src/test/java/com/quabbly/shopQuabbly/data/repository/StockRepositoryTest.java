package com.quabbly.shopQuabbly.data.repository;

import com.quabbly.shopQuabbly.data.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class StockRepositoryTest {

    @Autowired
    StockRepository stockRepository;
    Stock newStock;

    @BeforeEach
    void setUp() {
        newStock = new Stock();
        newStock.setName("headset");
        newStock.setCurrentPrice(12000);
    }

    @Test
    void AddStock(){
    assertThat(newStock.getId())
                    .isNull();
    log.info("incoming stock before saving -> {}", newStock);
    stockRepository.save(newStock);
    log.info("incoming stock after saving -> {}", newStock);
    assertThat(newStock.getId())
            .isNotNull();
    }

    @Test
    void testFindStock(){
        stockRepository.save(newStock);
        Stock foundStock =
                stockRepository.findById(1L).orElse(null);
        assertThat(foundStock).isNotNull();
    }
}