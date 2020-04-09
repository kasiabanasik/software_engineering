package importfromfiles;

import importfromfiles.service.PriceService;
import importfromfiles.service.ProductService;
import importfromfiles.service.StockService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleManager {

    private static final String WRITE_TO_FILE_ERROR = "Bład podczas zapisu do pliku.";
    private static final String FILE_NOT_FOUND = "Plik nie został znaleziony";
    private static Scanner scanner = new Scanner(System.in);

    private ProductService productService = new ProductService();
    private StockService stockService = new StockService();
    private DisplayManager displayManager = new DisplayManager();
    private PriceService priceService = new PriceService();

    public void redirectAction(int chosenAction) {
         switch(chosenAction) {
            case 0 :
                System.out.println("System wyłączany...");
                System.exit(0);

            case 1 :
                handleProductImport();
                break;

            case 2 :
                handleStockImport();
                break;
            case 3 :
                handlePriceImport();
                break;

            case 4 :
                getPriceHistory();
                break;
        }

    }

    public int getAction() {
        int chosenAction = 0;

        try {
            chosenAction = Integer.parseInt(scanner.next());
        } catch(NumberFormatException e) {
            System.out.println("Nieprawidłowy format");
            System.exit(0);
        }

        return chosenAction;
    }

    private void handleProductImport() {
        try {
            productService.importProducts();
            displayManager.displayProductList();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(WRITE_TO_FILE_ERROR);
        }
    }

    private void handleStockImport() {
        try {
            stockService.importStocks();
            displayManager.displayProductListWithStocks();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(WRITE_TO_FILE_ERROR);
        }
    }

    private void handlePriceImport() {
        try {
            priceService.importPrices();
            displayManager.displayProductListWithStocksAndPrices();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(WRITE_TO_FILE_ERROR);
        }
    }

    private void getPriceHistory() {
        System.out.println("Podaj produkt którego historię chcesz zobaczyć:");
        String productName = scanner.next();
            if (productService.isProductOnList(productName)) {
                priceService.getPriceHistoryForProductFromProductList(productName).forEach(item -> System.out.println(item.toString()));
            } else {
                System.out.println("Nie posiadamy takiego produktu");
            }
    }
}
