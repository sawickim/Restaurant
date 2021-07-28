package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inteca.creditApp.controller.dto.CustomerDTO;
import pl.inteca.creditApp.controller.dto.ProductDTO;
import pl.inteca.creditApp.exception.CustomerDoesNotExistException;
import pl.inteca.creditApp.exception.CustomerPeselAlreadyExistException;
import pl.inteca.creditApp.exception.ProductDoesNotExistException;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.model.ProductHibernate;
import pl.inteca.creditApp.repository.CreditHibernateRepository;
import pl.inteca.creditApp.repository.CustomerHibernateRepository;
import pl.inteca.creditApp.repository.ProductHibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetCreditUseCase {

    private final CreditHibernateRepository creditHibernateRepository;
    private final CustomerHibernateRepository customerHibernateRepository;
    private final ProductHibernateRepository productHibernateRepository;

    public String getCreditNumber(String pesel){
        if(!customerHibernateRepository.findByPesel(pesel).isPresent())
            throw new CustomerPeselAlreadyExistException("Nie ma osoby o podanym numerze pesel " + pesel);

        return creditHibernateRepository.findByCustomersContains(customerHibernateRepository.findByPesel(pesel)).get().getCreditNumber();
    }

    public List<CreditHibernate> getAllCredit(){
        return creditHibernateRepository.findAll();
    }

    public Optional<CreditHibernate> getAllClientWithTheSameCreditNumber(String creditNumber){
        return creditHibernateRepository.findByCreditNumber(creditNumber);
    }

    public Optional<CreditHibernate> getAllProductWithTheSameCreditNumber(String creditNumber){
        return creditHibernateRepository.findByCreditNumber(creditNumber);
    }

    public Optional<CreditHibernate> getListCreditsWithCustomerContains(String firstname, String surname, String pesel){

        if(!customerHibernateRepository.findByFirstnameAndSurnameAndPesel(firstname, surname, pesel).isPresent()){
            throw new CustomerDoesNotExistException("Dane klienta nie zawieraja sie w bazie danych");
        }

        return creditHibernateRepository.findByCustomersContains(customerHibernateRepository.findByFirstnameAndSurnameAndPesel(firstname, surname, pesel));
    }

    public Optional<CreditHibernate> getListCreditsWithProductContains(String productName, Double value){

        if(!productHibernateRepository.findByProductNameAndValue(productName, value).isPresent()){
            throw new ProductDoesNotExistException("Dane productu nie istnieją");
        }
        return creditHibernateRepository.findByProductsContains(productHibernateRepository.findByProductNameAndValue(productName, value));
    }
}
