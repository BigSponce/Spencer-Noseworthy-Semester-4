import java.util.Scanner;

public class MovieTheater {

    private static final int ROWS = 5;
    private static final int COLS = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] seats = new char[ROWS][COLS];
        initSeats(seats);

        System.out.println("Movie Theater Seating (O=Open, X=Reserved)");
        printSeating(seats);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1) Show seating");
            System.out.println("2) Reserve a seat");
            System.out.println("3) Cancel a reservation");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = askInt(scanner, "", 0, 3);
            switch (choice) {
                case 1:
                    printSeating(seats);
                    break;
                case 2: {
                    int row = promptRowLetter(scanner);
                    int col = askInt(scanner, "Enter seat (1-" + COLS + "): ", 1, COLS) - 1;
                    if (reserve(seats, row, col)) {
                        System.out.println("\nSeat reserved.");
                    } else {
                        System.out.println("\nSeat already reserved or invalid.");
                    }
                    break;
                }
                case 3: {
                    int row = promptRowLetter(scanner);
                    int col = askInt(scanner, "Enter seat (1-" + COLS + "): ", 1, COLS) - 1;
                    if (cancel(seats, row, col)) {
                        System.out.println("Reservation canceled.");
                    } else {
                        System.out.println("Seat not reserved or invalid.");
                    }
                    break;
                }
                case 0:
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void initSeats(char[][] seats) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                seats[r][c] = 'O'; // Open
            }
        }
    }

    private static void printSeating(char[][] seats) {
        System.out.print("     ");
        for (int c = 1; c <= COLS; c++) {
            System.out.printf("%2d ", c);
        }
        System.out.println();
        for (int r = 0; r < ROWS; r++) {
            System.out.printf("Row %c ", rowLabel(r));
            for (int c = 0; c < COLS; c++) {
                System.out.printf(" %c ", seats[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean reserve(char[][] seats, int row, int col) {
        if (!inBounds(row, col)) return false;
        if (seats[row][col] == 'X') return false;
        seats[row][col] = 'X';
        return true;
    }

    private static boolean cancel(char[][] seats, int row, int col) {
        if (!inBounds(row, col)) return false;
        if (seats[row][col] == 'O') return false;
        seats[row][col] = 'O';
        return true;
    }


    private static boolean inBounds(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    private static int askInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            if (!prompt.isEmpty()) System.out.print(prompt);
            String token = scanner.next();
            try {
                int val = Integer.parseInt(token);
                if (val >= min && val <= max) return val;
            } catch (NumberFormatException ignored) { }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    private static char rowLabel(int rowIndex) {
        return (char) ('A' + rowIndex);
    }

    private static int promptRowLetter(Scanner scanner) {
        while (true) {
            char maxLabel = rowLabel(ROWS - 1);
            System.out.print("Enter row (A-" + maxLabel + "): ");
            String token = scanner.next();
            if (token != null && !token.isEmpty()) {
                char ch = Character.toUpperCase(token.charAt(0));
                if (ch >= 'A' && ch <= maxLabel) {
                    return ch - 'A';
                }
            }
            System.out.println("Please enter a letter between A and " + maxLabel + ".");
        }
    }
}