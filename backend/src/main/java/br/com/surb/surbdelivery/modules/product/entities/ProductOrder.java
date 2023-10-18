package br.com.surb.surbdelivery.modules.product.entities;

import br.com.surb.surbdelivery.shared.AppEnums.ProductOrderStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_product_order")
public class ProductOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = -1947054358110270627L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varbinary(36)")
    private UUID ProductOrderId;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant createdAt;
    private ProductOrderStatus status;
    private Double total;

}
