package pl.inteca.creditApp.controller.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.inteca.creditApp.controller.dto.CustomerDTO;
import pl.inteca.creditApp.controller.dto.ProductWithTheSameCreditNumberDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCreditCommand {
    private Long id;

    private String creditName;

    private String creditNumber;

    private List<CustomerDTO> customers = new ArrayList<>();

    private List<ProductWithTheSameCreditNumberDTO> products = new ArrayList<>();
}
