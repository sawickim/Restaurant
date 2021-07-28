package pl.inteca.creditApp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "credit")
public class CreditHibernate {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "credit_name")
    private String creditName;

    @Column(name = "credit_number")
    private String creditNumber;

    @OneToMany(mappedBy = "credits")
    private List<CustomerHibernate> customers;

    @OneToMany(mappedBy = "credits")
    private List<ProductHibernate> products;
}
