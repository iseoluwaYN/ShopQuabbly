package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.exception.StockException;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.repository.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock create(StockDTO stockDTO) {
        if(stockDTO != null){
        validateStockVariables(stockDTO);
        ModelMapper modelMapper = new ModelMapper();
        Stock stock = modelMapper.map(stockDTO, Stock.class);
        return stockRepository.save(stock);
        }
        else {
            throw new StockException("Stock cannot be null");
        }
    }

    @Override
    public void update(StockDTO stockDTO) {

    }

    @Override
    public Stock getStock(Long id) {
        return null;
    }

    @Override
    public List<Stock> findAllStocksById() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private void validateStockVariables(StockDTO stockDTO) {
        if (stockDTO.getName() == null || stockDTO.getName().isBlank()
                || stockDTO.getName().isEmpty()) {
            throw new StockException("Stock must not have empty name");
        }
        if (stockDTO.getCurrentPrice() == 0 || stockDTO.getCurrentPrice() < 0) {
            throw new StockException("Stock price cannot be zero or have negative value");
        }

    }


}
