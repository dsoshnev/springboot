package ru.dsoshnev.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dsoshnev.springboot.model.Product;
import ru.dsoshnev.springboot.model.ProductException;
import ru.dsoshnev.springboot.service.ProductService;

import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PostMapping("/save")
    public String addNew(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/index";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable Long id, Model model) throws Exception {
        Optional<Product> product = productService.findById(id);
        if(product.isEmpty()) {
            throw new ProductException("Product not found");
        }
        model.addAttribute("product", product);
        return "product";
    }

    @ExceptionHandler({ProductException.class, Exception.class})
    public String handleException(Exception ex, Model model) {
        model.addAttribute("message", ex.getClass().getName() + ": " + ex.getMessage());
        model.addAttribute("stacktrace", ex.getStackTrace());
        return "error";
    }
}
