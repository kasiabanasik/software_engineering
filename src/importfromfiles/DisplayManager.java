package importfromfiles;

import importfromfiles.service.ProductService;

import java.util.Objects;

public class DisplayManager {

    private ProductService productService = new ProductService();

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Import produktów");
        System.out.println("2. Import stocków");
        System.out.println("3. Import cen");
        System.out.println("4. Historia zaimportowanych cen dla produktów");
        System.out.println("0. Zamknij program");
    }

    public void displayProductList() {
        System.out.println("Zaimportowane produkty:");
        productService.getProductList().forEach(item -> System.out.println(item.getName()));
    }

    public void displayProductListWithStocks() {
        System.out.println("Zaimportowane produkty:");
        productService.getProductList().stream().filter(item -> Objects.nonNull(item.getStock())).forEach(item -> {
            System.out.print(item.getName() + ": " +item.getStock().getQuantity());
            System.out.println();
        });
    }

    public void displayProductListWithStocksAndPrices() {
        System.out.println("Produkty z cenami:");
        productService.getProductList().stream().filter(item -> Objects.nonNull(item.getPriceList()) && !item.getPriceList().isEmpty()).forEach(item -> {
            System.out.print(item.getName() + ": ");
            item.getPriceList().forEach(price -> System.out.print(price.getValue() + " 3"));
            System.out.println();
        });
    }
}
