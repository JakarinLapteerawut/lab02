public class OX {


        private String[][] table = {
                {" ", "0", "1", "2"} ,
                {"0", "-", "-", "-"} ,
                {"1", "-", "-", "-"} ,
                {"2", "-", "-", "-"} ,
        };
        private String player;
        private int countX;
        private int countO;
        private int countDraw;

        public OX(){
            player = "X";
            countX = 0;
            countO = 0;
            countDraw = 0;



        }



        public String getTableString() {
            String result="";
            for(int row=0; row<table.length; row++){
                for( int colume=0; colume<table[row].length; colume++){
                    result = result + table[row][colume];
                }
                result = result + "\n";

            }
            return result;
        }



        public String getCurrentPlay() {

            return player;
        }

        public int getCountO() {

            return countO;
        }


        public int getCountX() {

            return countX;
        }

        public int getCountDraw() {


            return countDraw;
        }

        public   String get(int col,int row){
            if(col > 2 || col < 0 || row > 2 || row < 0) {
                return null;
            }
            return  table[row+1][col+1];



        }



        public boolean put(int col , int row) {
            try{
                if(!table[row+1][col+1].equals("-")){
                    return false;

                }
                table[row+1][col+1] = getCurrentPlay();
            }  catch(ArrayIndexOutOfBoundsException e){
                    return false;
            }


            return true;
    }

    public void switchPlayer() {
            if(player=="X") {
                player = "O";
            } else{
                player = "X";
            }
    }

    public boolean checkWin(int col,int row) {
            boolean colWin =true;

        for (int i=0; i<3; i++) {
            if (!table[i+1][col+1].equals(player)) {

                colWin = false;
            }

        }
        if(colWin){

            return true;

        }

        boolean rowWin =true;

        for (int i=0; i<3; i++) {
            if (!table[row+1][i+1].equals(getCurrentPlay())) {

               rowWin = false;
            }

        }

        if(rowWin){

            return true;
        }

        boolean csWin =true;

        for (int i=0; i<3; i++) {
            if (!table[i+1][i+1].equals(getCurrentPlay())) {

                csWin = false;

            }

        }

        if(csWin){

            return true;
        }


            return false;
    }


}
