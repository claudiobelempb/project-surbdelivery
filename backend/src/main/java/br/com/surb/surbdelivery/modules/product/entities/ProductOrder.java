package br.com.surb.surbdelivery.modules.product.entities;

import br.com.surb.surbdelivery.shared.AppEnums.ProductOrderStatus;
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
@Table(name = "tb_product_order")
public class ProductOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = -1947054358110270627L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(columnDefinition = "varchar(36)")
    private UUID ProductOrderId;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double total;
    private ProductOrderStatus status;
    private Instant createdAt;
    private Instant updatedAt;


    @ManyToMany
    @JoinTable(
            name = "tb_product_order_association",
            joinColumns = @JoinColumn(name = "product_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private final Set<Product> products = new HashSet<>();

    @PrePersist
    public void prePersist(){
        createdAt = Instant.now();
        if(Objects.isNull(ProductOrderId)) {
            ProductOrderId = UUID.randomUUID();
        }
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

}
