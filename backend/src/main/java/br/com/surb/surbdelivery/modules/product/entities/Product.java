package br.com.surb.surbdelivery.modules.product.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 4042976405544267787L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(columnDefinition = "varchar(36)")
    private UUID productId;
    private String name;
    private Double price;
    private String description;
    private  String imageUri;

}
