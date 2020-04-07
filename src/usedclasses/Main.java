package usedclasses;

import usedclasses.model.Product;
import usedclasses.service.InstallmentsService;
import usedclasses.service.PeselService;
import usedclasses.service.PriceService;
import usedclasses.service.ProductService;

import java.util.List;

public class Main {

    private static ProductService productService = new ProductService();
    private static InstallmentsService installmentsService = new InstallmentsService();
    private static DisplayManager displayManager = new DisplayManager();
    private static ConsoleManager consoleManager = new ConsoleManager(productService, new PriceService(), installmentsService,  new PeselService());

    public static void main(String[] args) {
        List<Product> productList = productService.getProductList();

        displayManager.displayProducts(productList);

        String productName = consoleManager.getProductName();
        double productPrice = consoleManager.getProductPrice();
        int howManyInstallements = consoleManager.getInstallmentsNumber();
        String pesel = consoleManager.getPesel();
        float interestsPercent= installmentsService.getInterestsPercent(howManyInstallements);
        float interestsPercentToDisplay = interestsPercent * 100;
        double installment = installmentsService.calculateInstallments(productPrice, howManyInstallements, interestsPercent);

        displayManager.displayInfo(productName, productPrice, pesel, howManyInstallements, interestsPercentToDisplay, installment);
    }
}
