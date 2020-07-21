package first_tasks.usedclasses.service;

import first_tasks.usedclasses.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        initializeProducts();
    }

    public boolean checkIfProductIsAvailable(String name){
        return products.stream().anyMatch(prod -> prod.getName().equalsIgnoreCase(name) && prod.getStock() > 0);
    }

    public List<Product> getProductList() {
        return products;
    }

    private void initializeProducts() {
        products.add(new Product("Macbook", 3));
        products.add(new Product("iPhone", 0));
        products.add(new Product("Samsung TV", 6));
    }
}
