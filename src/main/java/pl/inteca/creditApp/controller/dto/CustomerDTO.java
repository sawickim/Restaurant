package pl.inteca.creditApp.controller.dto;

import lombok.Data;
import pl.inteca.creditApp.model.CreditHibernate;
import pl.inteca.creditApp.model.CustomerHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private Long id;

    private String firstname;

    private String surname;

    private String pesel;

    public CustomerDTO(CustomerHibernate customerHibernate){
        ObjectMapperUtils.map(customerHibernate,this);
    }
}
