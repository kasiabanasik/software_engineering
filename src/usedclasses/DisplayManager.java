package usedclasses;

import usedclasses.product.Product;

import java.util.List;

public class DisplayManager {

    public void displayInfo(String productName, double productPrice, String pesel, int installmentsNumber, float interestsPercent, double installment) {
        System.out.println("Product name: " + productName);
        System.out.println("Product price: " + productPrice);
        System.out.println("PESEL: " + pesel);
        System.out.println("Ilość rat: " + installmentsNumber);
        System.out.println("Procent odsetek: " + interestsPercent + "%");
        System.out.println("Wysokość raty: " + installment);
    }

    public void displayProducts(List<Product> products) {
        System.out.println("Lista produktów: ");
        products.forEach(System.out::println);
    }

}
