package com.quabbly.shopQuabbly.data.services;

import com.quabbly.shopQuabbly.data.dto.StockDTO;
import com.quabbly.shopQuabbly.data.exception.StockException;
import com.quabbly.shopQuabbly.data.model.Stock;
import com.quabbly.shopQuabbly.data.repository.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Stock update(Long id, StockDTO stockDTO) {
        if(stockDTO == null){
            throw new StockException("Stock cannot be null");
        }
        validateStockVariables (stockDTO);
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            Stock foundStock = optionalStock.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(stockDTO, foundStock);
            return foundStock;
        }
        throw new StockException("Stock with this id does not exist");
    }

    @Override
    public Stock getStock(Long id) {
        Optional<Stock> stockToGet = stockRepository.findById(id);
        if(stockToGet.isPresent()){
            return stockToGet.get();
        }else {
            throw new StockException("Stock does not exist");
        }
    }

    @Override
    public List<Stock> findAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        stock.ifPresent(value -> stockRepository.delete(value));
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
