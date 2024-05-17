package Main;

public class Plateau {
    private final int xSize;
    private final int ySize;
    private int[][] plateau;


    public Plateau(int x,int y) {
        this.xSize = x;
        this.ySize= y;
        initialisePlateau();

    }
    private void initialisePlateau(){
        plateau = new int[xSize+3][ySize+3]; //+2 to account for boundary
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

    public boolean checkBoundary(Rover r) {
        int roverX = r.getX()+1; // to account for correct position in plateau boundary
        int roverY = r.getY()+1;
        if(r.getFacing() == CompassDirection.N){
            return plateau[roverX][roverY - 1] != 2;
        }else if (r.getFacing() == CompassDirection.S){
            return plateau[roverX][roverY +1 ] != 2;
        }else if (r.getFacing() ==CompassDirection.E){
            return plateau[roverX + 1][roverY] != 2;
        }else if (r.getFacing() == CompassDirection.W){
            return plateau[roverX - 1][roverY] != 2;

        }
        return true;
    }
}
