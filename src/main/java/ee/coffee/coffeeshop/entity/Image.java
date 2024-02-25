package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String originalFileName;

    @Column
    private Long size;

    @Column
    private String contentType;

    @Column
    private boolean previewImage;

    @Lob    // large obj
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
}



