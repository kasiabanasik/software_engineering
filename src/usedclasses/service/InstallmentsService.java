package usedclasses.service;

public class InstallmentsService {

    public boolean isTheInstallmentsAmounCorrect(int howMany) {
        return howMany <= 48 && howMany >= 8;
    }

    public double calculateInstallments(double productPrice, int installmentsNumber, double percent){
        double result = productPrice * percent / (double) installmentsNumber;
        long rounded = Math.round(result * 100);
        return (double)rounded / 100;
    }

    public float getInterestsPercent(int howManyInstallments){
        if(howManyInstallments >= 6 && howManyInstallments <= 12 ) {
            return 0.035f;
        } else if(howManyInstallments >= 13 && howManyInstallments <= 24 ) {
            return 0.055f;
        } else if(howManyInstallments >= 25 && howManyInstallments <= 48 ) {
            return 0.12f;
        }
        return 0.0f;
    }
}
