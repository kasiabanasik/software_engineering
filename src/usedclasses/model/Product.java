package usedclasses.model;

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

    @Override
    public int hashCode() {
        int result = 17;

        if (name != null) {
            result = 31 * result + name.hashCode();
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Product))
            return false;
        Product other = (Product)obj;
        boolean nameEquals = (this.name == null && other == null)
                || (this.name != null && this.name.equals(other.name));
        return this.stock == other.stock && nameEquals;
    }
}
