package pl.inteca.creditApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDTO implements Serializable {

    private Long id;

    private String creditName;

    private String creditNumber;

    private List<CustomerDTO> customers= new ArrayList<>();

    private List<ProductWithTheSameCreditNumberDTO> products = new ArrayList<>();

    public CreditDTO(CreditHibernate allCredit) {
        ObjectMapperUtils.map(allCredit, this);
    }
}
