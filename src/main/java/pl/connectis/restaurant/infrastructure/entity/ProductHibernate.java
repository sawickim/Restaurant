package pl.connectis.restaurant.infrastructure.entity;

import pl.connectis.restaurant.domain.model.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "product")
public class ProductHibernate {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int stored_amount;

    public ProductHibernate() {
    }

    public ProductHibernate(Long id, String name, int stored_amount) {
        this.id = id;
        this.name = name;
        this.stored_amount = stored_amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStored_amount() {
        return stored_amount;
    }

    public void setStored_amount(int stored_amount) {
        this.stored_amount = stored_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductHibernate productHibernate = (ProductHibernate) o;
        return Objects.equals(id, productHibernate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stored_amount=" + stored_amount +
                '}';
    }
}
