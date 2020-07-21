package importfromfiles.service;

import importfromfiles.model.Stock;
import importfromfiles.utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static importfromfiles.constants.PathsConstants.*;

public class StockService {

    private ProductService productService = new ProductService();
    private FileService fileService = new FileService();

    public void importStocks() throws IOException {
        File file = FileReader.readFile(STOCKS_IMPORT_FILE.getValue());

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String stockLine = scanner.nextLine();
            String[] splittedStockLine = stockLine.split(SEPARATOR.getValue());
            addStockToProduct(splittedStockLine[0], new Stock(splittedStockLine[1], splittedStockLine[2]));
            fileService.saveToFile(stockLine, STOCKS_FILE.getValue());
        }
    }

    private void addStockToProduct(String productName, Stock stock){
        productService.setStockForProduct(productName, stock);
    }
}
