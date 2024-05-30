package InputParser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Main.Colour;
import Main.Instruction;

public class InstructionParser {
private Instruction instruction;
    public InstructionParser() {
    }

    public List<Instruction> validateOption() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        List<Instruction> instructionList = new ArrayList<>();
        String userSelect = "";
        do {
            System.out.print(Colour.message+"Please give an movement sequence using the letters above. e.g LMLMLMR: "+Colour.RESET);

            try {
                userSelect = scanner.nextLine();
                if (userSelect.matches("^[LRMlrm]+$")) {
                    for (char letter : userSelect.toCharArray()) {
                        if (letter == 'L'|| letter == 'l') {
                            instructionList.add(Instruction.L);
                        } else if (letter == 'R'|| letter == 'r') {
                            instructionList.add(Instruction.R);
                        } else if (letter == 'M' || letter == 'm') {
                            instructionList.add(Instruction.M);
                        }
                    }
                    flag = false;
                }else{
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println(Colour.error+"[!] INVALID sequence! please input a character string using ONLY L,R,M"+Colour.RESET);
            }

        } while (flag);
        return instructionList;
    }
}
