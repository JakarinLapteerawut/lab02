import java.util.Scanner;

public class Games {
    public static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col,row;



    public static void  input(){
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlay() + " (Col): ");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlay() + " (Row): ");
            row = sc.nextInt();
            canPut = ox.put(col,row);
            if(!canPut) {
                System.out.println("Please input number between 0-2");
            }
        } while(!canPut);

    }


    public static  void main(String[] args) {

        ox = new OX();
        while (true) {
            System.out.print(ox.getTableString());
            input();
            ox.put(col,row);
            ox.switchPlayer();
            if(ox.checkWin(col,row)) {
                break;

            }
        }
    }


}



