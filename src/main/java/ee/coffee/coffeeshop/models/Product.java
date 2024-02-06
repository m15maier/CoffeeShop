package ee.coffee.coffeeshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name= "products")
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private int price;


    private LocalDateTime dateOfCreated;
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

}


