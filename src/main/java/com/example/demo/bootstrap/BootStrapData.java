package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        // adding only if the samples are empty
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            addSampleInventory();
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }

    private void addSampleInventory() {
        // Sample data. Checks and adds the parts if they don't already exist
        addPartIfNotExists("Engine V8", 2500.00, 5);
        addPartIfNotExists("All-Season Tire", 150.00, 20);
        addPartIfNotExists("Brake Pads", 75.00, 30);
        addPartIfNotExists("12V Battery", 120.00, 15);
        addPartIfNotExists("Spark Plugs", 10.00, 100);

        // Sample data. Checks and adds products if they don't already exist
        addProductIfNotExists("Mustang GT", 35000.00, 2);
        addProductIfNotExists("Camaro SS", 37000.00, 3);
        addProductIfNotExists("Charger R/T", 32000.00, 1);
        addProductIfNotExists("Corvette Z06", 75000.00, 1);
        addProductIfNotExists("Tesla Model S", 80000.00, 2);

        System.out.println("Sample Inventory");
    }
    private void addPartIfNotExists(String name, double price, int inv) {
        Optional<Part> part = partRepository.findByName(name);
        if (part.isEmpty()) {
            InhousePart newPart = new InhousePart();
            newPart.setName(name);
            newPart.setPrice(price);
            newPart.setInv(inv);
            int minInventory = 1;
            newPart.setMinInventory(minInventory); //sets minimum inventory
            int maxInventory = 9;
            newPart.setMaxInventory(maxInventory); // Sets maximum inventory
            partRepository.save(newPart); 
        }
    }

    private void addProductIfNotExists(String name, double price, int inv) {
        Optional<Product> product = productRepository.findByName(name);
        if (product.isEmpty()) {
            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setPrice(price);
            newProduct.setInv(inv);
            productRepository.save(newProduct);
        }
    }
}
