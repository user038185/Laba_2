import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expr;

        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Введите выражение: ");
            expr = keyboard.nextLine();

            Tree tree = new Tree(expr);

            if (Expression.check_brackets(expr)) {
                System.out.println("Выpажение пpавильное");

                Expression.print_details(tree.get_tree(), 0);
                System.out.println("Результат вычислений: ");
                System.out.println(Expression.calculate(tree.get_tree()));

            } else
                System.out.println("Выpажение непpавильное");


        } while (!expr.equals("0"));
    }
}