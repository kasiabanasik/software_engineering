package first_tasks.usedclasses.service;

public class InstallmentsService {

    private static final int MAX_INSTALLMENTS_NUMBER = 48;
    private static final int MIN_INTALLMENTS_NUMBER = 6;
    private static final float THIRTY_FIVE_PERCENT_INTERESTS = 0.035f;
    private static final float FIFTY_FIVE_PERCENT_INTERESTS = 0.055f;
    private static final float TWELVE_PERCENT_INTERESTS = 0.12f;
    private static final int ONE_HUNDRED_MULTIPLIER = 100;

    public boolean isTheInstallmentsAmounCorrect(int howMany) {
        return howMany <= MAX_INSTALLMENTS_NUMBER && howMany >= MIN_INTALLMENTS_NUMBER;
    }

    public double calculateInstallments(double productPrice, int installmentsNumber, double percent){
        double result = productPrice * percent / (double) installmentsNumber;
        long rounded = Math.round(result * ONE_HUNDRED_MULTIPLIER);
        return (double)rounded / ONE_HUNDRED_MULTIPLIER;
    }

    public float getInterestsPercent(int howManyInstallments){
        if(howManyInstallments >= MIN_INTALLMENTS_NUMBER && howManyInstallments <= 12 ) {
            return THIRTY_FIVE_PERCENT_INTERESTS;
        } else if(howManyInstallments >= 13 && howManyInstallments <= 24 ) {
            return FIFTY_FIVE_PERCENT_INTERESTS;
        } else {
            return TWELVE_PERCENT_INTERESTS;
        }
    }
}
