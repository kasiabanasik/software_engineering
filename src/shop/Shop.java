package shop;

import java.util.Scanner;

public class Shop {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] pesels = new String[]{"12345", "12987", "123"};
    private static String[] products = new String[]{"Samsung TV", "Macbook", "iPhone"};
    private static int[] productStocks = new int[]{3, 6, 0};

    public static void main(String[] args) {

        displayProducts();

        String productName = setProduct();
        double productPrice = setProductPrice();
        int howManyInstallements = setInstallmentsNumber();
        String pesel = setPesel();
        float interestsPercent= getInterestsPercent(howManyInstallements);
        float interestsPercentToDisplay = interestsPercent * 100;
        double installment = calculateInstallments(productPrice, howManyInstallements, interestsPercent);

        displayInfo(productName, productPrice, pesel, howManyInstallements, interestsPercentToDisplay, installment);

    }

    private static void displayProducts() {
        System.out.println("Lista produktów: ");
        for (String product: products) {
            System.out.println(product);
        }
    }

    private static String setProduct() {
        System.out.println("Podaj nazwę produktu:");
        String productName;
        if(scanner.hasNext()) {
            productName = scanner.next();
            for (int i=0 ; i < products.length; i++) {
                if (productName.equalsIgnoreCase(products[i]) && productStocks[i] > 0) {
                    return productName;
                }
            }

            System.out.println("Nie posiadamy takiego produktu lub nie ma go w stocku.");
        }

        return setProduct();
    }

    private static void displayInfo(String productName, double productPrice, String pesel, int installmentsNumber, float interestsPercent, double installment) {
        System.out.println("Product name: " + productName);
        System.out.println("Product price: " + productPrice);
        System.out.println("PESEL: " + pesel);
        System.out.println("Ilość rat: " + installmentsNumber);
        System.out.println("Procent odsetek: " + interestsPercent + "%");
        System.out.println("Wysokość raty: " + installment);
    }

    private static double setProductPrice() {
        System.out.println("Podaj cenę towaru:");
        double priceDouble;
        try {
            if (scanner.hasNext()) {
                priceDouble = Double.valueOf(scanner.next());
                if (priceDouble < 400000 && priceDouble > 1500) {
                    return priceDouble;
                } else {
                    System.out.println("Cena produktu musi mieścić się w granicach: 1500 - 40 tys");
                    return setProductPrice();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Zły fromat ceny.");
            return setProductPrice();
        }
        return setProductPrice();
    }

    private static int setInstallmentsNumber(){
        System.out.println("Podaj liczbę rat:");
         if(scanner.hasNext()) {
             String howManyString = scanner.next();
             try {
                int howMany = Integer.parseInt(howManyString);
                if(howMany <= 48 && howMany >= 8) {
                    return howMany;
                }
                System.out.println("Ilosć rat musi się mieścić w granicach 8 - 48");
             } catch (NumberFormatException e) {
                 System.out.println("Give the correct price amount:");
                 return setInstallmentsNumber();
             }
         }
        return setInstallmentsNumber();
    }

     private static String setPesel(){
        System.out.println("Podaj pesel:");
         if(scanner.hasNext()) {
             String pesel = scanner.next();
             if(isPeselCorrect(pesel)){
                 return pesel;
             } else {
                 System.out.println("Pesel nieprawidłowy. Raty nieprzyznane");
             }
         }
         System.exit(0);
         return "";
    }

    private static boolean isPeselCorrect(String pesel){
        String regex = "[0-9]+";
        for (String s : pesels) {
            if (s.equals(pesel) && s.matches(regex)) {
                return true;
            }
        }
        return false;
    }

    private static float getInterestsPercent(int howManyInstallments){
        if(howManyInstallments >= 6 && howManyInstallments <= 12 ) {
            return 0.035f;
        } else if(howManyInstallments >= 13 && howManyInstallments <= 24 ) {
            return 0.055f;
        } else if(howManyInstallments >= 25 && howManyInstallments <= 48 ) {
            return 0.12f;
        }
        System.out.println("Nieprawidłowa ilość rat");
        return 0.0f;
    }

    private static double calculateInstallments(double productPrice, int installmentsNumber, double percent){
        double result = productPrice * percent / (double) installmentsNumber;
        long rounded = Math.round(result * 100);
        return (double)rounded / 100;
    }
}
