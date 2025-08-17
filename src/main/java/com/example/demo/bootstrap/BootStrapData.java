package com.example.demo.bootstrap;

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
        if (productRepository.count() > 0 || partRepository.count() > 0) {
            System.err.println("Database already contains data, bypassing bootstrapdata");
            return;
        }



        OutsourcedPart barbellClamp= new OutsourcedPart();
        barbellClamp.setCompanyName("Rogue Fitness");
        barbellClamp.setName("Barbell Clamp");
        barbellClamp.setInv(5);
        barbellClamp.setPrice(20.0);
        barbellClamp.setId(100L);
        outsourcedPartRepository.save(barbellClamp);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        Product squatRack= new Product("Power Squat Rack",799.99,30);
        Product benchPress= new Product("Flat Bench Press Station",549.99,30);
        Product deadLiftPlatform= new Product("Deadlift Platform",999.99,20);
        Product dumbbellSet= new Product("Adjustable Dumbbell Set",750.0,25);
        Product multiStationTower= new Product("Multi-Station Tower",1499.99,20);
        productRepository.save(squatRack);
        productRepository.save(benchPress);
        productRepository.save(deadLiftPlatform);
        productRepository.save(dumbbellSet);
        productRepository.save(multiStationTower);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
