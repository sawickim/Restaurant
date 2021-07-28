package pl.inteca.creditApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.inteca.creditApp.controller.dto.ProductDTO;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.model.ProductHibernate;

import java.util.List;
import java.util.Optional;

public interface CreditHibernateRepository extends JpaRepository<CreditHibernate, Long>,
        JpaSpecificationExecutor<CreditHibernate> {

    Optional<CreditHibernate> findByCreditName(String symbol);

    Optional<CreditHibernate> findByCreditNumber(String number);

    Optional<CreditHibernate> findByCustomersContains(Optional<CustomerHibernate> customers);

    List<CreditHibernate> findAll();

    Optional<CreditHibernate> findByProductsContains(Optional<ProductHibernate> products);

    Optional<List<CreditHibernate>> findAllByProductsIn(List<ProductHibernate> products);

}
