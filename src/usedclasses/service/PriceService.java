package usedclasses.service;

public class PriceService {

    private static final int MAX_PRICE = 400000;
    private static final int MIN_PRICE = 1500;

    public boolean isPriceCorrect(double price) {
        return price < MAX_PRICE && price > MIN_PRICE;
    }
}
