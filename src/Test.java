import java.util.Random;

public class Test {

     public void test() {

         System.out.println("Tablica; liczb losowych: ");

         int [] table = getRandomNumbers(10);
         display(table);
         displayPrimary(table);
         int[] sorted = sort(table);

         System.out.println("\nPosortowana tablica: ");
         display(sorted);
     }

    private int[] getRandomNumbers(int size) {
        Random random = new Random();
        int[] table = new int[size];

        for (int i = 0; i < table.length; i++) {
            table[i] = random.nextInt(99) + 1;
        }

        return table;
    }

    private void display(int[] table){
           for (int i = 0; i <table.length; i++) {
             System.out.print(table[i] + " ");
         }
    }

    private boolean isPrimary(int number) {
        if (number == 1 || number == 0) {
            return false;
        }

        int amount = 0;

        for (int i = 1; i <= number; i++) {

            if (number % i == 0) {
                amount++;
            }

            if (amount > 2) {
                return false;
            }
        }

        return true;
    }

    private void displayPrimary(int[] numbers) {
        System.out.println(" \nLiczby pierwsze: ");

        for (int i = 0; i < numbers.length; i++) {
            if (isPrimary(numbers[i])) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    private int[] sort(int[] table) {
         while(true){
             int moved = 0;
             for (int i = 0; i < table.length - 1; i++) {
                if (table[i] > table[i + 1]) {
                    moved++;
                    int temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                }
            }

            if(moved == 0) {
                return table;
            }
         }
    }
}
