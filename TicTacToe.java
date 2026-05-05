import java.util.Random;

public class ComputerMove {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Reusable method from UC6
    public static boolean placeMove(int row, int col, char symbol) {
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    // Display board
    public static void displayBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // UC7: Computer makes random move
    public static void computerMove(char symbol) {
        Random rand = new Random();
        boolean movePlaced = false;

        while (!movePlaced) {
            int slot = rand.nextInt(9) + 1; // 1–9

            // Convert slot to row & column
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            // Try placing move
            movePlaced = placeMove(row, col, symbol);
        }

        System.out.println("Computer placed " + symbol);
    }

    public static void main(String[] args) {
        // Example run
        displayBoard();

        computerMove('O'); // computer plays O

        displayBoard();
    }
}
