package importfromfiles.service;

import importfromfiles.model.Price;
import importfromfiles.model.Product;
import importfromfiles.model.Stock;
import importfromfiles.utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static importfromfiles.constants.FilesConstants.PRODUCTS_FILE;
import static importfromfiles.constants.FilesConstants.PRODUCTS_IMPORT_FILE;

public class ProductService {

    private static List<Product> productList = new ArrayList<>();
    private FileService fileService = new FileService();

    public void addToProductList(String productName) {
        productList.add(new Product(productName));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setStockForProduct(String productName, Stock stock) {
        productList.stream().filter(product -> product.getName().equals(productName)).findFirst().ifPresent(item -> item.setStock(stock));
    }

    public void addPriceToProduct(String productName, Price price) {
        productList.stream().filter(product -> product.getName().equals(productName)).findFirst().ifPresent(item -> item.addToPriceList(price));
    }

    public void importProducts() throws IOException {
        File file = FileReader.readFile(PRODUCTS_IMPORT_FILE.getValue());

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String productName = scanner.nextLine();
            addToProductList(productName);
            fileService.saveToFile(productName, PRODUCTS_FILE.getValue());
        }
    }

    public boolean isProductOnList(String productName) {
        return productList.stream().anyMatch(item -> item.getName().equals(productName));
    }
}
