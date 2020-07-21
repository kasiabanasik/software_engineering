package first_tasks.usedclasses.service;

import java.util.ArrayList;
import java.util.List;

public class PeselService {

    private List<String> allowedPesels = new ArrayList<>();

    public boolean isPeselCorrect(String userPesel) {
        initializeAllowedPesels();
        String regex = "[0-9]+";
        return allowedPesels.stream().filter(pesel -> pesel.matches(regex)).anyMatch(pesel -> pesel.equalsIgnoreCase(userPesel));
    }

    private void initializeAllowedPesels() {
        allowedPesels.add("12345");
        allowedPesels.add("123");
        allowedPesels.add("234");
    }

}
