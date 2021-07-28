package pl.inteca.creditApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.inteca.creditApp.model.CustomerHibernate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CustomerHibernateRepository extends JpaRepository<CustomerHibernate,Long>, JpaSpecificationExecutor<CustomerHibernate> {

    Optional<CustomerHibernate> findByPesel(String pesel);

    List<CustomerHibernate> findAll();

    Optional<CustomerHibernate> findByFirstnameAndSurnameAndPesel(String firstname, String surname, String pesel);
}
