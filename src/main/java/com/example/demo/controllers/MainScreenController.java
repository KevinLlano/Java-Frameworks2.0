package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 *
 *
 */

@RestController
@RequestMapping("/api")
public class MainScreenController {

    private final PartService partService;
    private final ProductService productService;

    public MainScreenController(PartService partService, ProductService productService) {
        this.partService = partService;
        this.productService = productService;
    }

    @GetMapping("/mainscreen")
    public List<Object> getMainscreenData(@Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword) {
        // Fetch parts and products using services
        List<Part> partList = partService.listAll(partkeyword);
        List<Product> productList = productService.listAll(productkeyword);

        // Return a combined list of parts and products
        return List.of(partList, productList);
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
