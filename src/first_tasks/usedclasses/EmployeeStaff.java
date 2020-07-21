package first_tasks.usedclasses;

import java.util.Random;
import java.util.Scanner;

public class EmployeeStaff {
    private static final String[] employees = new String[]{"Jarek", "Darek", "Maria", "Ala", "Ela", "Michał"};
    private static double[] salaries = new double[]{1200.0, 1450.0, 1350.0, 2500.0, 3500.0, 1110.0};

    public static void main(String[] args) {
        tabDisplay();
        addBonus(salaries, 100);
        tabDisplay();
        System.out.println(addExtraBonus(1000));
        sortSalaries();
        System.out.println("\nSorted: ");
        salariesDisplay();
        System.out.println();
        drawTriangle();
//        drawWhile(5);
    }

    public static void addBonus(double[] salaries, int bonus) {
        double b = (double) bonus;
        System.out.println();
        for (int i = 0; i < salaries.length; i++) {
            salaries[i]+=b;
        }
    }

    public static void tabDisplay() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] + " pensja: " + salaries[i]);
        }
        System.out.println("_______________________________________");
    }

     public static void salariesDisplay() {
        for (int i = 0; i < salaries.length; i++) {
            System.out.print(salaries[i] + " ");
        }
    }

    public static String addExtraBonus(int extraBonus) {
        Random random = new Random();
        int index = random.nextInt(4) + 1;
        double newSalary = salaries[index] + extraBonus;

        return employees[index] + " pensja: " + newSalary;
    }

    private static void sortSalaries() {
        while (true) {
            int changes = 0;
            for (int i = 1; i < salaries.length; i++) {
                if (salaries[i - 1] > salaries[i]) {
                    double temp = salaries[i - 1];
                    salaries[i - 1] = salaries[i];
                    salaries[i] = temp;
                    changes++;
                }
            }
            if (changes == 0) {
                break;
            }
        }
    }

    private static void drawTriangle(){

        System.out.println("\n Please pass size: ");
        Scanner in = new Scanner(System.in);

        if(in.hasNext()){
            int size = Integer.parseInt(in.next());
            draw(size);
        }

    }

    private static void draw(int size) {
        for (int i = 0; i <= size; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

         for (int i = size-1; i > 0; i--) {
            for(int k = i; k <= i && k > 0; k--) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

//    private static void drawWhile(int size) {
//
//        while(true) {
//            int i=0;
//
//           for (int j = 0; j <= i; j++) {
//                System.out.print("*");
//                i++;
//
//                if(i > size) break;
//            }
//            System.out.println();
//             for (int k = i; k <= i && k > 0; k--) {
//                System.out.print("*");
//                i--;
//
//                if(i==0) break;
//            }
//             System.out.println();
//             break;
//        }
//
//    }
}
