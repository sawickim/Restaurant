package pl.inteca.creditApp.controller.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerCommand {

    private Long id;

    private String firstName;

    private String surname;

    private String pesel;

    private String numberCredit;
}
