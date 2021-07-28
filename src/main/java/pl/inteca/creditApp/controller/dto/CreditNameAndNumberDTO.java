package pl.inteca.creditApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditNameAndNumberDTO {

    private Long id;

    private String creditName;

    private String creditNumber;

    public CreditNameAndNumberDTO(CreditHibernate credit) {
        ObjectMapperUtils.map(credit,this);
    }
}
