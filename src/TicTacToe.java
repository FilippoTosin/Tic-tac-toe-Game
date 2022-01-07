import java.util.*;

public class TicTacToe {

    public static int checkWin(int[][] board){
        int i;

        for (i=0; i<3; i++)
            if (board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][1]!=0)
                return board[i][0];
        for (i=0; i<3; i++)
            if (board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[1][i]!=0)
                return board[1][i];
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[1][1]!=0)
            return board[1][1];
        if (board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[1][1]!=0)
            return board[1][1];
        return 0;
    }

    public static void printBoard(int[][] board){
        int i, j;

        for(i=0; i<3; i++)
            System.out.print("+-");
        System.out.println("+");
        for(i=0; i<3; i++) {
            for (j = 0; j<3; j++) {
                if (board[i][j] == 0)
                    System.out.print("| ");
                else if (board[i][j] == 1)
                    System.out.print("|X");
                else if (board[i][j] == 2)
                    System.out.print("|O");
            }
            System.out.println("|");
            for(j=0; j<3; j++)
                System.out.print("+-");
            System.out.println("+");
        }
        System.out.println();
    }

    public static boolean fullBoardCheck(int[][] board){
        int i, j;
        for(i=0; i<3; i++)
            for(j=0; j<3; j++)
                if (board[i][j]==0)
                    return false;
        return true;
    }

    public static int[] inputPc(int[][] board){
        int[] pos = new int[2];
        boolean valid=false;
        Random rand = new Random();

        do{
            pos[0] = rand.nextInt(3);
            pos[1] = rand.nextInt(3);
            if(board[pos[0]][pos[1]]==0){
                valid = true;
            }
        }
        while (valid==false);

        return pos;
    }

    public static void main(String[] args) {
        int x, y, i, j, res=0;
        boolean win = false, valid;
        Scanner in = new Scanner (System.in);
        int[][] board = new int[3][3];
        int[] pos;

        for(i=0; i<3; i++)
            for(j=0; j<3; j++)
                board[i][j]=0;

        while(win==false) {
            do {
                valid = true;
                System.out.println("Inserire coordinata x:");
                x = in.nextInt();
                System.out.println("Inserire coordinata y:");
                y = in.nextInt();

                if (fullBoardCheck(board)==true)
                    win = true;
                else if (x<1 || x>3 || y<1 || y>3 || board[x - 1][y - 1] != 0)
                    valid = false;
            }
            while(valid==false);

            if (win==false) {
                board[x - 1][y - 1] = 1;
                res = checkWin(board);
                printBoard(board);
            }

            if (res==0 && win==false){
                pos = inputPc(board);
                board[pos[0]][pos[1]]=2;
                res = checkWin(board);
                printBoard(board);
            }
            else
                win=true;
        }

        if (res==1)
            System.out.println("YOU WIN!!!");
        else if (res==2)
            System.out.println("You lost.. :(");
        else
            System.out.println("Draw :|");
    }
}
