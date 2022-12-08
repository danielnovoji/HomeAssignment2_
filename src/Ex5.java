import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
            char[] board = new char[9];
            int position;
            boolean winner;
            char symbol='x';
            for (int i=0;i< board.length;i++){
                position=getPositionFromUser(board);
                if(i%2 == 0)
                    symbol= 'x';
                else
                    symbol='o';
                winner=placeSymbolOnBoard(board,position,symbol);
                if (winner)
                    break;
            }
        }
    public static void printBoard(char[] board){
        for (int i=0;i<3;i++)
            System.out.print(board[i]+" ");
        System.out.println();
        for (int k=3;k<6;k++)
            System.out.print(board[k]+" ");
        System.out.println();
        for (int j=6;j< board.length;j++)
            System.out.print(board[j]+" ");
        System.out.println();
    }
    public static boolean placeSymbolOnBoard(char[] board,int position,char symbol){
            board[position-1]=symbol;
            printBoard(board);
            boolean winner=false;
            char check = checkWinner(board);
            if (check=='x') {
                System.out.println("X is Winner");
                winner=true;
            }
            if (check=='o'){
                System.out.println("o is Winner");
                winner=true;
            }
            return winner;
        }
    public static char checkWinner(char[] board){
            String x = "xxx";
            String o = "ooo";
            String check="";
            char winner = '-';
            for (int i=0;i<7;i=i+3){
                check=Character.toString(board[i])+Character.toString(board[i+1])+Character.toString(board[i+2]);
                if (check.equals(x)){
                    winner='x';
                    break;}
                if (check.equals(o)){
                    winner='o';
                    break;
                }
            }
            for (int j=0;j<3;j++) {
                check = Character.toString(board[j]) + Character.toString(board[j + 3]) + Character.toString(board[j + 6]);
                if (check.equals(x)) {
                    winner = 'x';
                    break;
                }
                if (check.equals(o)) {
                    winner = 'o';
                    break;
                }
            }
            for (int k=0;k<4;k=k+3){
                if (k<3) {
                    check = Character.toString(board[k]) + Character.toString(board[k + 4]) + Character.toString(board[k + 8]);
                }
                if (k==3){
                    check = Character.toString(board[k]) + Character.toString(board[k + 2]) + Character.toString(board[k+4]);
                }
                if (check.equals(x)){
                    winner='x';
                    break;}
                if (check.equals(o)) {
                    winner = 'o';
                    break;
                }}


            return winner;
        }
    public static int getPositionFromUser(char[] board){
            int position;
            Scanner scanner = new Scanner(System.in);
            boolean check=true;
            do {
                System.out.println("Enter your position");
                position = scanner.nextInt();
                if(position<10 && position>0){
                    check=isAvailable(board,position);
                    if (check==false)
                        System.out.println("The position is taken, enter another position");
                }
                else
                    System.out.println("The number is not in the correct range. Enter a new number in the range 1-9");
            } while (position>10 || position<0 || check==false);
            return position;
        }
    public static boolean isAvailable(char[] board,int position){
            boolean available = true;
            if (board[position-1] == 'x' || board[position-1] == 'o')
                available=false;
            return available;
        }
    }