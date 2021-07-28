package pl.inteca.creditApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.inteca.creditApp.controller.dto.*;
import pl.inteca.creditApp.controller.dto.command.AddCreditCommand;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.model.ProductHibernate;
import pl.inteca.creditApp.usecase.AddCreditUseCase;
import pl.inteca.creditApp.usecase.GetCreditUseCase;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {

    private final AddCreditUseCase addCreditUseCase;
    private final GetCreditUseCase getCreditUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody AddCreditCommand command){
        addCreditUseCase.add(command);
    }

    @GetMapping("/creditNumbers/{pesel}")
    public String getCreditNumber(@PathVariable("pesel") String pesel){
        return getCreditUseCase.getCreditNumber(pesel);
    }

    @GetMapping
    public List<CreditDTO> getAllCredit(){
        return getCreditUseCase.getAllCredit().stream().map(CreditDTO::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/clients/{creditNumber}")
    public List<CustomerWithTheSameCreditNumberDTO> getAllClientWithTheSameCreditNumber(@PathVariable("creditNumber") String creditNumber){
        return getCreditUseCase.getAllClientWithTheSameCreditNumber(creditNumber).stream().map(CustomerWithTheSameCreditNumberDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/products/{creditNumber}")
    public List<ProductWithTheSameCreditNumberDTO> getAllProductWithTheSameCreditNumber(@PathVariable("creditNumber") String creditNumber){
        return getCreditUseCase.getAllProductWithTheSameCreditNumber(creditNumber).stream().map(ProductWithTheSameCreditNumberDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/listOfCredits/firstname/{firstname}/surname/{surname}/pesel/{pesel}")
    @ResponseBody
    public List<CreditNameAndNumberDTO> getListCreditsWithCustomerContains(@PathVariable("firstname") String firstname, @PathVariable("surname") String surname, @PathVariable("pesel") String pesel){
        return getCreditUseCase.getListCreditsWithCustomerContains(firstname,surname,pesel).stream().map(CreditNameAndNumberDTO::new).collect(Collectors.toList()).stream().collect(Collectors.toList());
    }

    @GetMapping("listOfCredits/product/{productName}/value/{value}")
    @ResponseBody
    public  List<CreditNameAndNumberDTO> getListCreditsWithProductContains(@PathVariable("productName") String productName, @PathVariable("value") Double value){
        return getCreditUseCase.getListCreditsWithProductContains(productName,value).stream().map(CreditNameAndNumberDTO::new).collect(Collectors.toList()).stream().collect(Collectors.toList());
    }
}
