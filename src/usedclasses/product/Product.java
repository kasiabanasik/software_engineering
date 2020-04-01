package usedclasses.product;

public class Product {

    private String name;
    private int stock;


    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
            return "Product name: " + this.name;
    }
}
