package pl.inteca.creditApp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class CustomerHibernate {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String surname;
    private String pesel;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private CreditHibernate credits;
}
