package Main;

public class Plateau {
    private final int xSize;
    private final int ySize;
    private int[][] plateau;
    private int roverX;
    private int roverY;

    public Plateau(int x,int y) {
        this.xSize = x;
        this.ySize= y;
        initialisePlateau();

    }
    private void initialisePlateau(){
        plateau = new int[xSize+2][ySize+2]; //+2 to account for boundary
        for(int i=0; i< plateau.length;i++){
            for (int j=0; j< plateau[0].length;j++){
                if (i == 0 || j==0 || i== plateau.length-1 || j== plateau[0].length-1){
                    plateau[i][j] = 2;
                }else{
                    plateau[i][j]=0;
                }
            }
        }

    }
    public int[][] getPlateau() {
        return plateau;
    }

    public void checkBoundary(Rover r) {

    }
}
