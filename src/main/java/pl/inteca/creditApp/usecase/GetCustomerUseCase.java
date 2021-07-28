package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.repository.CustomerHibernateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetCustomerUseCase {

    private final CustomerHibernateRepository customerHibernateRepository;

    public List<CustomerHibernate> getAllCustomer(){
        return customerHibernateRepository.findAll();
    }
}
