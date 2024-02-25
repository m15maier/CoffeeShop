package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table    // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title;

    @Column(length = 1024)
    private String description;

    @Column
    private String size;

    @Column
    private BigDecimal price;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "product")
    // cascadeType.ALL - при удалении товара, удалятся и фото;
    // LAZY - сначала подгружается товар, пото фото
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    private Image previewImage;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}