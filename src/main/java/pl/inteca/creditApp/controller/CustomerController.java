package pl.inteca.creditApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.inteca.creditApp.controller.dto.CreditDTO;
import pl.inteca.creditApp.controller.dto.CustomerDTO;
import pl.inteca.creditApp.controller.dto.command.AddCustomerCommand;
import pl.inteca.creditApp.usecase.AddCustomerUseCase;
import pl.inteca.creditApp.usecase.GetCreditUseCase;
import pl.inteca.creditApp.usecase.GetCustomerUseCase;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final AddCustomerUseCase addCustomerUseCase;
    private final GetCustomerUseCase getCustomerUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long add(@RequestBody AddCustomerCommand command){

        return addCustomerUseCase.add(command);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomer(){
        return getCustomerUseCase.getAllCustomer().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }
}
