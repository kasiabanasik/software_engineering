package shop;

import java.util.Scanner;

public class Shop {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] pesels = new String[]{"12345", "12987", "123"};

    public static void main(String[] args) {


        String productName = "";
        double productPrice;
        int howManyInstallements;
        String pesel;

        System.out.println("Podaj nazwę towaru:");
        if(scanner.hasNext()) {
            productName = scanner.next();
        }
        productPrice = setProductPrice();
        howManyInstallements = setInstallmentsNumber();
        pesel = setPesel();
        double interestsPercent= getInterestsPercent(howManyInstallements);
        double interestsPercentToDisplay = interestsPercent*100;
        double installment = calculateInstallments(productPrice, howManyInstallements, interestsPercent);

        displayInfo(productName, productPrice, pesel, howManyInstallements, interestsPercentToDisplay, installment);

    }

    private static void displayInfo(String productName, double productPrice, String pesel, int installmentsNumber, double interestsPercent, double installment) {
        System.out.println("Product name:" + productName);
        System.out.println("Product price:" + productPrice);
        System.out.println("PESEL:" + pesel);
        System.out.println("Ilość rat:" + installmentsNumber);
        System.out.println("Procent odsetek: " + interestsPercent + "%");
        System.out.println("Wysokość raty: " + installment);
    }

    private static double setProductPrice() {
        System.out.println("Podaj cenę towaru:");
        double priceDouble = 0.0;
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
//                 return setPesel();
             }
         }
         System.exit(0);
         return "";
//        return setPesel();
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

    private static double getInterestsPercent(int howManyInstallments){
        if(howManyInstallments >= 6 && howManyInstallments <= 12 ) {
            return 0.035;
        } else if(howManyInstallments >= 13 && howManyInstallments <= 24 ) {
            return 0.055;
        } else if(howManyInstallments >= 25 && howManyInstallments <= 48 ) {
            return 0.12;
        }
        System.out.println("Nieprawidłowa ilość rat");
        return 0.0;
    }

    private static double calculateInstallments(double productPrice, int installmentsNumber, double percent){
        double result = productPrice * percent / (double) installmentsNumber;
        long rounded = Math.round(result * 100);
        return (double)rounded / 100;
    }
}
