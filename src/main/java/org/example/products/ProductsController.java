package org.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
@Autowired
    private ProductService productservice;
    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return productservice.getAllProducts();
    }
    @RequestMapping("/products/{id}")
  public Product getProduct(@PathVariable int id){
        return productservice.getProduct(id);
  }
@RequestMapping(method= RequestMethod.POST, value= "/products")
  public void addProduct(@RequestBody Product product){
        productservice.addProduct(product);
  }
@RequestMapping(method = RequestMethod.PUT, value="/products/{id}")
  public void updateProduct(@RequestBody Product product,@PathVariable int id ){
        productservice.updateProduct(id, product);
  }
    @RequestMapping(method = RequestMethod.DELETE, value="/products/{id}")
  public void deleteProduct(@PathVariable int id){
        productservice.deleteProduct(id);
    }
}
