package InputParser;

import Main.Colour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuParser {

    public int validateOption() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        int userSelect = 0;
        do {
            System.out.println();
            System.out.print(Colour.message+"Please select an option (1-4): "+Colour.RESET);
            try {
                userSelect = scanner.nextInt();
                if (userSelect >= 1 && userSelect <= 4) {
                    flag = false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println(Colour.error+"[!] INVALID OPTION! please select an option between 1-4"+Colour.RESET);

            }
        } while (flag);

        return userSelect;
    }
}
