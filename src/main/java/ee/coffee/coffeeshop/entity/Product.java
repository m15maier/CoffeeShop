package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "product")    // cascadeType.ALL - при удалении товара, удалятся и фото; LAZY - сначала подгружается товар, пото фото
    private List<Image> images = new ArrayList<>();
    private Long preview_image_id;
    private LocalDateTime localDateTime;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;


    private void init() {
        localDateTime = LocalDateTime.now();
    }

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }


}