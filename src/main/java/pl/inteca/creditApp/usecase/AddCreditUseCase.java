package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.inteca.creditApp.controller.dto.command.AddCreditCommand;
import pl.inteca.creditApp.exception.CreditNameAndNumberAlreadyExistException;
import pl.inteca.creditApp.exception.CustomerPeselAlreadyExistException;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.repository.CreditHibernateRepository;
import pl.inteca.creditApp.repository.CustomerHibernateRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional(rollbackOn = Throwable.class)
@RequiredArgsConstructor
public class AddCreditUseCase {

    private final CreditHibernateRepository creditHibernateRepository;
    private final CustomerHibernateRepository customerHibernateRepository;

    public Long add(AddCreditCommand command){
        validateCreditNameAndNumber(command.getCreditName(), command.getCreditNumber());
        return creditHibernateRepository.save(prepareCredit(command)).getId();
    }

    public CreditHibernate prepareCredit(AddCreditCommand command){
        CreditHibernate creditHibernate = new CreditHibernate();
        creditHibernate.setCreditName(command.getCreditName());
        String number = randomGenerator();
        creditHibernate.setCreditNumber(number);

        return creditHibernate;
    }

    private String randomGenerator(){
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

    private void validateCreditNameAndNumber(String symbol, String number){
        Optional<CreditHibernate> creditHibernateName = creditHibernateRepository.findByCreditName(symbol);

        if (creditHibernateName.isPresent())
            throw new CreditNameAndNumberAlreadyExistException("Podana nazwa credytu " + symbol + "juz istnieje");

        Optional<CreditHibernate> creditHibernateNumber = creditHibernateRepository.findByCreditNumber(number);

        if (creditHibernateNumber.isPresent())
            throw new CreditNameAndNumberAlreadyExistException("Podany numer kredytu" + number + "już istnieje");
    }


}
