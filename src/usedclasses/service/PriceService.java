package usedclasses.service;

public class PriceService {

    public boolean isPriceCorrect(double price) {
        return price < 400000 && price > 1500;
    }
}
