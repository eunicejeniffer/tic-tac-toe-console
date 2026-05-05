import java.util.Scanner;
import java.util.Random;

public class TicTacToeUC8 {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // Display board
    public static void displayBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    // UC6: Place move
    public static boolean placeMove(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    // UC7: Computer random move
    public static void computerMove(char symbol) {
        boolean placed = false;

        while (!placed) {
            int slot = rand.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            placed = placeMove(row, col, symbol);
        }

        System.out.println("Computer placed " + symbol);
    }

    // Check winner
    public static boolean checkWin(char s) {
        // rows, columns, diagonals
        return (board[0][0] == s && board[0][1] == s && board[0][2] == s) ||
               (board[1][0] == s && board[1][1] == s && board[1][2] == s) ||
               (board[2][0] == s && board[2][1] == s && board[2][2] == s) ||

               (board[0][0] == s && board[1][0] == s && board[2][0] == s) ||
               (board[0][1] == s && board[1][1] == s && board[2][1] == s) ||
               (board[0][2] == s && board[1][2] == s && board[2][2] == s) ||

               (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
               (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }

    // Check draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    // UC8: Game loop
    public static void startGame() {
        char currentPlayer = 'X'; // Human = X, Computer = O
        boolean gameRunning = true;

        while (gameRunning) {
            displayBoard();

            if (currentPlayer == 'X') {
                // Human turn
                System.out.print("Enter row (0-2): ");
                int row = sc.nextInt();
                System.out.print("Enter col (0-2): ");
                int col = sc.nextInt();

                if (!placeMove(row, col, currentPlayer)) {
                    System.out.println("Invalid move! Try again.");
                    continue; // retry same player
                }
            } else {
                // Computer turn
                computerMove(currentPlayer);
            }

            // Check win
            if (checkWin(currentPlayer)) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            }
            // Check draw
            else if (isDraw()) {
                displayBoard();
                System.out.println("Game is a Draw!");
                gameRunning = false;
            }
            // Switch turn
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void main(String[] args) {
        startGame();
    }
}
