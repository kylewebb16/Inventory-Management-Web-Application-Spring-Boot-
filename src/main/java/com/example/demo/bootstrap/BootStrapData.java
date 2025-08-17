package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);
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
        // Check if database is already populated
        if (productRepository.count() > 0 || partRepository.count() > 0) {
            // Do not populate default data if so, log to server
            log.info("Database already contains data, bypassing default data initialization");
            return;
        }

        // Populate five parts and products
        initializeDefaultParts();
        initializeDefaultProducts();
        log.info("Database empty, initialized default parts and products");

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }

    private void initializeDefaultProducts() {
        productRepository.save(new Product("Power Squat Rack",799.99,30));
        productRepository.save(new Product("Flat Bench Press Station",549.99,30));
        productRepository.save(new Product("Deadlift Platform",999.99,20));
        productRepository.save(new Product("Adjustable Dumbbell Set",750.0,25));
        productRepository.save(new Product("Multi-Station Tower",1499.99,20));
    }

    private void initializeDefaultParts() {
        OutsourcedPart barbellClamp= new OutsourcedPart();
        barbellClamp.setCompanyName("Rogue Fitness");
        barbellClamp.setName("Barbell Clamp");
        barbellClamp.setInv(5);
        barbellClamp.setPrice(20.0);
        outsourcedPartRepository.save(barbellClamp);

        InhousePart fiveLbPlate = new InhousePart();
        fiveLbPlate.setName("5 lb Steel Plate");
        fiveLbPlate.setInv(100);
        fiveLbPlate.setPrice(14.99);
        fiveLbPlate.setPartId(1);
        partRepository.save(fiveLbPlate);

        InhousePart tenLbPlate = new InhousePart();
        tenLbPlate.setName("10 lb Steel Plate");
        tenLbPlate.setInv(50);
        tenLbPlate.setPrice(29.99);
        tenLbPlate.setPartId(2);
        partRepository.save(tenLbPlate);

        InhousePart fourtyFiveLbPlate = new InhousePart();
        fourtyFiveLbPlate.setName("45 lb Steel Plate");
        fourtyFiveLbPlate.setInv(50);
        fourtyFiveLbPlate.setPrice(89.99);
        fourtyFiveLbPlate.setPartId(3);
        partRepository.save(fourtyFiveLbPlate);

        InhousePart rackUprights = new InhousePart();
        rackUprights.setName("Rack Uprights (Individual Posts)");
        rackUprights.setInv(200);
        rackUprights.setPrice(199.99);
        rackUprights.setPartId(4);
        partRepository.save(rackUprights);
    }
}
