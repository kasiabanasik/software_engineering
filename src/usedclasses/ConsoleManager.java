package usedclasses;

import usedclasses.service.InstallmentsService;
import usedclasses.service.PeselService;
import usedclasses.service.PriceService;
import usedclasses.service.ProductService;

import java.util.Scanner;

public class ConsoleManager {

    private static Scanner scanner = new Scanner(System.in);
    private ProductService productService;
    private PriceService priceService;
    private InstallmentsService installmentsService;
    private PeselService peselService;

    public ConsoleManager(ProductService productService, PriceService priceService, InstallmentsService installmentsService, PeselService peselService) {
        this.productService = productService;
        this.priceService = priceService;
        this.installmentsService = installmentsService;
        this.peselService = peselService;
    }

    public String getProductName() {
        System.out.println("Podaj nazwę produktu:");
        String productName;
        if(scanner.hasNext()) {
            productName = scanner.next();
            if (productService.checkIfProductIsAvailable(productName)) {
                return productName;
            }

            System.out.println("Nie posiadamy takiego produktu lub nie ma go w stocku.");
        }

        return getProductName();
    }

    public double getProductPrice() {
        System.out.println("Podaj cenę towaru:");
        double priceDouble;
        try {
            if (scanner.hasNext()) {
                priceDouble = Double.valueOf(scanner.next());
                if (priceService.isPriceCorrect(priceDouble)) {
                    return priceDouble;
                } else {
                    System.out.println("Cena produktu musi mieścić się w granicach: 1500 - 40 tys");
                    return getProductPrice();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Zły fromat ceny.");
            return getProductPrice();
        }
        return getProductPrice();
    }

    public int getInstallmentsNumber(){
        System.out.println("Podaj liczbę rat:");

         if(scanner.hasNext()) {
             String howManyString = scanner.next();
             try {
                int howMany = Integer.parseInt(howManyString);

                if (installmentsService.isTheInstallmentsAmounCorrect(howMany)) {
                    return howMany;
                }
                System.out.println("Ilosć rat musi się mieścić w granicach 8 - 48");
             } catch (NumberFormatException e) {
                 System.out.println("Give the correct price amount:");
                 return getInstallmentsNumber();
             }
         }
        return getInstallmentsNumber();
    }

    public String getPesel(){
        System.out.println("Podaj pesel:");
         if(scanner.hasNext()) {
             String pesel = scanner.next();
             if(peselService.isPeselCorrect(pesel)){
                 return pesel;
             } else {
                 System.out.println("Pesel nieprawidłowy. Raty nieprzyznane");
             }
         }
         System.exit(0);
         return "";
    }
}
