package pl.inteca.creditApp.controller.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.inteca.creditApp.controller.dto.CreditDTO;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCommand {

    private long id;

    private String productName;

    private Double value;

    private Long creditId;

    private String numberCredit;
}
