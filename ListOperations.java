import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        String input = scanner.nextLine();

        for (int i = 0; i < parts.length; i++) {
            numbers.add(Integer.parseInt(parts[i]));
        }

        while (!input.equals("End")) {
            String[] temp = input.split("\\s+");

            if (temp[0].equals("Add")) {
                numbers.add(Integer.parseInt(temp[1]));
            }

            if (temp[0].equals("Remove")) {
                if (Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(Integer.parseInt(temp[1]));
                }
            }

            if (temp[0].equals("Insert")) {
                if (Integer.parseInt(temp[2]) < 0 || Integer.parseInt(temp[2]) >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]));
                }
            }

                if (temp[1].equals("left")) {
                    int a = 1;
                    while (a <= Integer.parseInt(temp[2])) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                        a++;
                    }
                }

            if (temp[1].equals("right")) {
                int a = 1;
                while (a <= Integer.parseInt(temp[2])) {
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size() - 1);
                    a++;
                }
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

}