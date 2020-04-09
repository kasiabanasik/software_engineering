package importfromfiles.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private String name;
    private Stock stock;
    private List<Price> priceList;

    public Product(String name) {
        this.name = name;
        priceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void addToPriceList(Price price){
        if(Objects.isNull(priceList)) {
            priceList = new ArrayList<>();
        }

        priceList.add(price);
    }

    @Override
    public String toString() {
            return "Product name: " + this.name;
    }

    @Override
    public int hashCode() {
        int result = 17;

        if (this.name != null) {
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
        return (this.name == null && other == null)
                || (this.name != null && this.name.equals(other.name));
    }
}
