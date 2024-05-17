package Main;

import InputParser.InstructionParser;

import java.util.List;
import java.util.Scanner;

public class MoveRover {
private Rover r1;
private InstructionParser IP;
public static Plateau plateau;
private List<Instruction> instructionSeq;


    public List<Instruction> getInstructionSeq() {
        return instructionSeq;
    }

    public Rover getR1() {
        return r1;
    }

    public MoveRover() {
        validatePlateauSize();
        r1 = new Rover();
        IP = new InstructionParser();


    }

    public void movingRoverToSpace(){
        System.out.println();
        System.out.println("initial R1 position: X,Y=("+r1.getX()+", "+r1.getY()+") "+r1.getFacing());
        System.out.println("Please choose either to ROTATE or MOVE the rover R1 using the options below:");
        System.out.println("L: Rotate Left");
        System.out.println("R: Rotate Right");
        System.out.println("M: move ROVER one space");
        instructionSeq = IP.validateOption();
        for (Instruction i : instructionSeq) {
            if (i == Instruction.R) {
                System.out.println("**Rotating right...**");
                r1.rotate(Instruction.R);
            } else if (i == Instruction.L) {
                System.out.println("**Rotating left...**");
                r1.rotate(Instruction.L);
            } else if (i == Instruction.M) {
                if (plateau.checkBoundary(r1)){
                    System.out.println("**Moving ...**");
                    r1.move(r1.getFacing());
                }else {
                    System.out.println("ERROR! Rover detected boundary cannot perform move.");
                }


            }
        }
        System.out.print("\n");
        System.out.println("R1 position NOW: X,Y=("+r1.getX()+", "+r1.getY()+") "+r1.getFacing());
    }

    public void validatePlateauSize(){
        System.out.print("Size of plateau [xSize] [ySize]: ");
        Scanner scanner = new Scanner(System .in);
        String input;
        do{
            input= scanner.nextLine();
            if (input.matches("\\d \\d") && input.length() == 3){
                plateau = new Plateau(Integer.parseInt(String.valueOf(input.charAt(0))),Integer.parseInt(String.valueOf(input.charAt(2))));
                break;
            }else{
                System.out.println("Invalid input format should be in ([x size] [y size]) e.g. 5 5");
                System.out.println("[xSize] = 1-9 [ySize] = 1-9");
                System.out.print("Size of plateau [xSize] [ySize]: ");
            }
        }while(true);

    }
}
