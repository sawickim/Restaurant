package pl.inteca.creditApp.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inteca.creditApp.model.ProductHibernate;
import pl.inteca.creditApp.repository.ProductHibernateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetProductUseCase {

    private final ProductHibernateRepository productHibernateRepository;

    public List<ProductHibernate> getAllProducts(){
        return productHibernateRepository.findAll();
    }
}
