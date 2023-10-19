package br.com.surb.surbdelivery.modules.product.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 4042976405544267787L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(36)")
    private UUID productId;
    private String name;
    private Double price;
    private String description;
    private  String imageUri;
    private Instant createdAt;
    private Instant updatedAt;


    @ManyToMany(mappedBy = "products")
    private final Set<ProductOrder> orders = new HashSet<>();

    @PrePersist
    public void prePersist(){
        createdAt = Instant.now();
        if(Objects.isNull(productId)) {
            productId = UUID.randomUUID();
        }
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

}
