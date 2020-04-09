package importfromfiles.model;

import java.util.Date;

public class Stock {

    private int quantity;
    private Date date;

    public Stock(String quantity, String date) {
        this.quantity = Integer.parseInt(quantity);
        this.date = new Date(date);
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }
}
