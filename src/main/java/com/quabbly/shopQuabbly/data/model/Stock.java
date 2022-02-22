package com.quabbly.shopQuabbly.data.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

}
