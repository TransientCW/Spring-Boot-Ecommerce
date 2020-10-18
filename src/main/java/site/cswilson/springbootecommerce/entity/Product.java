package site.cswilson.springbootecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity()
@Table(name = "product")
// Lombok takes care of getters/setters with this annotations - saves on boilerplate
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    // This is the other side of the relation. Since One product category can have many
    // products as seen in the ProductCategory @ManyToOne relation, here we set @ManyToOne
    // and join on the FK column in this table which is categoryId
    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private ProductCategory category;
    @Column(name = "SKU")
    private String sku;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "ACTIVE")
    private boolean active;
    @Column(name = "UNITS_IN_STOCK")
    private int unitsInStock;
    @Column(name = "DATE_CREATED")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated;
}
