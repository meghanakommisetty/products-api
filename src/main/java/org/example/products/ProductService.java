package org.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {
    @Autowired
   private ProductRepository productrepository;
    private List<Product> products = new ArrayList<> ( Arrays.asList(
            new Product(1, "apple", 7),
            new Product (2, "banana", 3)
    ));
     public List<Product> getAllProducts(){
         List<Product> products = new ArrayList<>();
         productrepository.findAll().forEach(products::add);
         return products;
     }
     public Product getProduct(int id){
        return productrepository.findOne(id);
     }

    public void addProduct(Product product) {
         productrepository.save(product);
    }

    public void updateProduct(int id, Product product) {
        productrepository.save(product);
    }

    public void deleteProduct(int id, Product product) {
        productrepository.delete(id);
    }
}
