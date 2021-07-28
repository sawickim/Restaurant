package pl.inteca.creditApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.ProductHibernate;

import java.util.List;
import java.util.Optional;

public interface ProductHibernateRepository extends JpaRepository<ProductHibernate, Long>, JpaSpecificationExecutor<ProductHibernate> {

    Optional<ProductHibernate> findByProductName(String product);

    List<ProductHibernate> findAll();

    Optional<ProductHibernate> findByProductNameAndValue(String productName, Double value);
}
