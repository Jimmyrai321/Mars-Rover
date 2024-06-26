package Main;

import java.util.Scanner;

public class Position {
    private int x;
    private int y;
    private CompassDirection facing;

    public Position() {
        validateRoverDrop();
    }

    public int getX() {
        return x;
    }

    public CompassDirection getFacing() {
        return facing;
    }

    public int getY() {
        return y;
    }

    public void setFacing(CompassDirection facing) {
        this.facing = facing;
    }

    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void validateRoverDrop(){
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean flag = true;
        do{
            System.out.print(Colour.message+"Where to drop Rover: "+Colour.RESET);
            input= scanner.nextLine();
            if (input.matches("\\d \\d [NESWnesw]") && input.length() == 5){
                this.x = Integer.parseInt(String.valueOf(input.charAt(0)));
                this.y = Integer.parseInt(String.valueOf(input.charAt(2)));
                switch (input.charAt(4)){
                    case 'N':
                    case 'n':
                        this.facing = CompassDirection.N;
                        break;
                    case 'E':
                    case 'e':
                        this.facing = CompassDirection.E;
                        break;
                    case 'S':
                    case 's':
                        this.facing = CompassDirection.S;
                        break;
                    case 'W':
                    case 'w':
                        this.facing = CompassDirection.W;
                        break;
                }
                try {
                    if (x > MoveRover.plateau.getPlateau().length - 3 || y > MoveRover.plateau.getPlateau()[0].length - 3) {
                        throw new IndexOutOfBoundsException();
                    }else{
                        flag = false;
                    }
                }catch (IndexOutOfBoundsException e){
                    System.out.println(Colour.error+"[!] ERROR! coordinates out of bounds from plateau!");
                    System.out.println("Please try again!"+Colour.RESET);
                }
            }else{
                System.out.println(Colour.error+"[!] Invalid input! Format should be in ([x position] [y position] [N/E/S/W]) e.g. 1 1 N"+Colour.RESET);
            }

        }while(flag);
    }

}
