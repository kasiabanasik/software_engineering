package importfromfiles.service;

import importfromfiles.model.Price;
import importfromfiles.utils.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static importfromfiles.constants.FilesConstants.*;

public class PriceService {

    private ProductService productService = new ProductService();
    private FileService fileService = new FileService();

    public void importPrices() throws IOException {
        File file = FileReader.readFile(PRICES_IMPORT_FILE.getValue());

        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String priceLine = scanner.nextLine();
            String[] splittedPrice = priceLine.split(SEPARATOR.getValue());
            addPriceToProduct(splittedPrice[0], new Price(BigDecimal.valueOf(Double.valueOf(splittedPrice[1])), new Date(splittedPrice[2])));
            fileService.saveToFile(priceLine, PRICES_HISTORY_FILE.getValue());
        }
    }

    public List<Price> getPriceHistoryForProduct(String product) throws FileNotFoundException {
        List<Price> prices = new ArrayList<>();
        File file = FileReader.readFile(PRICES_HISTORY_FILE.getValue());
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String priceHistoryLine = scanner.nextLine();
            String[] priceLineArray = priceHistoryLine.split(SEPARATOR.getValue());

            if (product.equals(priceLineArray[0])) {
                prices.add(new Price(BigDecimal.valueOf(Integer.parseInt(priceLineArray[1])), new Date(priceLineArray[2])));
            }
        }

        return prices;
    }

    public List<Price> getPriceHistoryForProductFromProductList(String product) {
        List<Price> priceList = new ArrayList<>();
        if (productService.isProductOnList(product)) {
            productService.getProductList().stream().filter(item -> item.getName().equals(product)).findFirst().ifPresent(item -> priceList.addAll(item.getPriceList()));
        }
        return priceList;
    }

    private void addPriceToProduct(String productName, Price price) {
        productService.addPriceToProduct(productName, price);
    }
}
