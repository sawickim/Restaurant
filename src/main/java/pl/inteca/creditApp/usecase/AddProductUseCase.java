package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.inteca.creditApp.controller.dto.command.AddProductCommand;
import pl.inteca.creditApp.exception.CreditNumberDoesNotExistException;
import pl.inteca.creditApp.exception.EntityDoesNotExistException;
import pl.inteca.creditApp.exception.ProductNameAlreadyExistException;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.ProductHibernate;
import pl.inteca.creditApp.repository.CreditHibernateRepository;
import pl.inteca.creditApp.repository.ProductHibernateRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Throwable.class)
@RequiredArgsConstructor
public class AddProductUseCase {

    private final ProductHibernateRepository productHibernateRepository;
    private final CreditHibernateRepository creditHibernateRepository;

    public Long add(AddProductCommand command){
        validProductName(command.getProductName());
        return productHibernateRepository.save(prepareProduct(command)).getId();
    }

    private ProductHibernate prepareProduct(AddProductCommand command){
        ProductHibernate productHibernate = new ProductHibernate();
        productHibernate.setProductName(command.getProductName());
        productHibernate.setValue(command.getValue());

        Optional<CreditHibernate> creditHibernateOptional = creditHibernateRepository.findByCreditNumber(command.getNumberCredit());
        if(!creditHibernateOptional.isPresent())
            throw new CreditNumberDoesNotExistException("Podany numer kredytu" + command.getNumberCredit() + "nie istnieje");

        productHibernate.setCredits(creditHibernateOptional.get());

        return productHibernate;
    }

    private void validProductName(String product){
        Optional<ProductHibernate> productHibernate = productHibernateRepository.findByProductName(product);

        if(productHibernate.isPresent())
            throw new ProductNameAlreadyExistException("Podany product" + product + "juz istnieje");
    }
}
