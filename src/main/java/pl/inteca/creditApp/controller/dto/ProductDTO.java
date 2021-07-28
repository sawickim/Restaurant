package pl.inteca.creditApp.controller.dto;

import lombok.Data;
import pl.inteca.creditApp.model.ProductHibernate;
import pl.inteca.creditApp.utils.ObjectMapperUtils;

import java.io.Serializable;
import java.math.BigDecimal;

    @Data
    public class ProductDTO implements Serializable {

        private Long id;

        private String productName;

        private Double value;

        public ProductDTO(ProductHibernate productHibernate){
            ObjectMapperUtils.map(productHibernate,this);        }
    }

