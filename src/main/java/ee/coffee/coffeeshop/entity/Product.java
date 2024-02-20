package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name= "products")    // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_title")
    private String title;

    @Column(name = "product_description", columnDefinition = "text")
    private String description;

    @Column(name = "product_size")
    private String size;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

}