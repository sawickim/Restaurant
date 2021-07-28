package pl.inteca.creditApp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class ProductHibernate {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "product_name")
    private String productName;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private CreditHibernate credits;
}
