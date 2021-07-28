package pl.inteca.creditApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWithTheSameCreditNumberDTO {

    private List<CustomerDTO> customers= new ArrayList<>();

    public CustomerWithTheSameCreditNumberDTO(CreditHibernate creditHibernate) {
        ObjectMapperUtils.map(creditHibernate, this);
    }
}
