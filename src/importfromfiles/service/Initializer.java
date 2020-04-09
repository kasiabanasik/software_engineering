package importfromfiles.service;

import importfromfiles.model.Price;
import importfromfiles.model.Product;
import importfromfiles.model.Stock;
import importfromfiles.utils.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static importfromfiles.constants.FilesConstants.*;

public class Initializer {

    public static final String CANNOT_INITIALIZE_FILE_NOT_FOUND = "Nie można zainicjować %s. Plik nieodnaleziony";
    private ProductService productService = new ProductService();

    public void initializeProductsFromFile() {
        File products = FileReader.readFile(PRODUCTS_FILE.getValue());
        Scanner scanner;
        try {
            scanner = new Scanner(products);
            while (scanner.hasNextLine()) {
                String product = scanner.nextLine();
                productService.addToProductList(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format(CANNOT_INITIALIZE_FILE_NOT_FOUND, "produktów"));
        }
    }

    public void initializePricesFromFile() {
        File products = FileReader.readFile(PRICES_HISTORY_FILE.getValue());
        Scanner scanner;
        try {
            scanner = new Scanner(products);
            while (scanner.hasNextLine()) {
                String priceLine = scanner.nextLine();
                String[] splitted = priceLine.split(SEPARATOR.getValue());
                if (productService.isProductOnList(splitted[0])) {
                    productService.addPriceToProduct(splitted[0], new Price(BigDecimal.valueOf(Integer.parseInt(splitted[1])), new Date(splitted[2])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format(CANNOT_INITIALIZE_FILE_NOT_FOUND, "cen"));
        }
    }

    public void initializeStocksFromFile() {
        File stocks = FileReader.readFile(STOCKS_FILE.getValue());
        Scanner scanner;
        Map<String, Stock> productStocks = new HashMap<>();

        try {
            scanner = new Scanner(stocks);
            while (scanner.hasNextLine()) {
                String stockLine = scanner.nextLine();
                String[] splitted = stockLine.split(SEPARATOR.getValue());
                if (productService.isProductOnList(splitted[0])) {
                    productStocks.put(splitted[0], new Stock(splitted[1], splitted[2]));
                }
            }
            List<Product> productList = productService.getProductList();
            productStocks.forEach((product, stock) -> productList.stream().filter(item -> item.getName().equals(product)).forEach(item -> item.setStock(stock)));
        } catch (FileNotFoundException e) {
            System.out.println(String.format(CANNOT_INITIALIZE_FILE_NOT_FOUND, "stoków"));
        }
    }
}
