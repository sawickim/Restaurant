package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.inteca.creditApp.controller.dto.command.AddCustomerCommand;
import pl.inteca.creditApp.exception.CreditNumberDoesNotExistException;
import pl.inteca.creditApp.exception.CustomerPeselAlreadyExistException;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.repository.CreditHibernateRepository;
import pl.inteca.creditApp.repository.CustomerHibernateRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Throwable.class)
@RequiredArgsConstructor
public class AddCustomerUseCase {

    private final CustomerHibernateRepository customerHibernateRepository;
    private final CreditHibernateRepository creditHibernateRepository;

    public Long add(AddCustomerCommand command){
        validateClientPesel(command.getPesel());
        return customerHibernateRepository.save(prepareClient(command)).getId();
    }

    private CustomerHibernate prepareClient(AddCustomerCommand command){
        CustomerHibernate customerHibernate = new CustomerHibernate();
        customerHibernate.setFirstname(command.getFirstName());
        customerHibernate.setSurname(command.getSurname());
        customerHibernate.setPesel(command.getPesel());

        Optional<CreditHibernate> creditHibernateOptional = creditHibernateRepository.findByCreditNumber(command.getNumberCredit());
        if(!creditHibernateOptional.isPresent())
            throw new CreditNumberDoesNotExistException("Kredyt o numerze " + command.getNumberCredit() + "nie istnieje");

        customerHibernate.setCredits(creditHibernateOptional.get());
        return customerHibernate;
    }

    private void validateClientPesel(String pesel){
        Optional<CustomerHibernate> customerHibernateOptional = customerHibernateRepository.findByPesel(pesel);
        if(customerHibernateOptional.isPresent())
            throw new CustomerPeselAlreadyExistException("Istnieje już osoba o numerze pesel " + pesel);
    }
}
