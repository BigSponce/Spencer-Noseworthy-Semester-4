import java.util.Scanner;

public class AverageTemp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature values (space-separated):");
        double[] temps;
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.print("Please enter at least one value: ");
                continue;
            }

            String[] parts = line.split("\\s+");
            temps = new double[parts.length];
            boolean valid = true;
            for (int i = 0; i < parts.length; i++) {
                try {
                    temps[i] = Double.parseDouble(parts[i]);
                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                System.out.print("Invalid number detected. Try again: ");
                continue;
            }
            break;
        }

        double sum = 0.0;
        for (double t : temps) {
            sum += t;
        }
        double average = sum / temps.length;

        int aboveCount = 0;
        for (double t : temps) {
            if (t > average) {
                aboveCount++;
            }
        }

        System.out.printf("Average temperature: %.2f%n", average);
        System.out.println("Values above average: " + aboveCount);

        scanner.close();
    }
}
