package pl.inteca.creditApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.inteca.creditApp.controller.dto.CustomerDTO;
import pl.inteca.creditApp.controller.dto.ProductDTO;
import pl.inteca.creditApp.controller.dto.command.AddProductCommand;
import pl.inteca.creditApp.usecase.AddProductUseCase;
import pl.inteca.creditApp.usecase.GetProductUseCase;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final AddProductUseCase addProductUseCase;
    private final GetProductUseCase getProductUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long add(@RequestBody AddProductCommand command){

        return addProductUseCase.add(command);
    }

    @GetMapping
    List<ProductDTO> getAllProducts(){
        return getProductUseCase.getAllProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
