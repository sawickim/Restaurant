package pl.inteca.creditApp.controller.dto;

import lombok.Data;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductWithTheSameCreditNumberDTO implements Serializable {

    private List<ProductDTO> products;

    public ProductWithTheSameCreditNumberDTO(CreditHibernate creditHibernate){
        ObjectMapperUtils.map(creditHibernate,this);
    }
}
