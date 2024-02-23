package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long image_id;

    @Column(name = "image_name")
    private String image_name;

    @Column(name = "original_file_name")
    private String original_file_name;

    @Column(name = "size")
    private Long size;

    @Column(name = "content_type")
    private String content_type;

    @Column(name = "is_preview_image")
    private boolean is_preview_image;

    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private  Product product;

}
