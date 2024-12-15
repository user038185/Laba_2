import java.util.Scanner;

class Expression {

    static void print_details(Branch Tree, int l) {
        if (Tree != null) {
            print_details(Tree.right, l + 1);
            for (int i = 1; i <= l; i++) System.out.print("    ");
            System.out.println(Tree.elem);
            print_details(Tree.left, l + 1);
        }
    }

    static int calculate(Branch Tree) {
        int num1, num2;
        if (Tree.left == null)
            return Tree.elem - '0';
        num1 = calculate(Tree.left);
        num2 = calculate(Tree.right);
        switch (Tree.elem) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return -1;
    }


    static int Priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 5;
    }

    static boolean check_brackets(String Expr) {
        char br1 = '(';
        char br2 = ')';

        Stack stack = new Stack(null);
        int OK = 1;
        for (int i = 0; (OK == 1) && (i != Expr.length()); i++) {

            if (Expr.charAt(i) == br1) { // открывающая скобка
                stack.Push(Expr.charAt(i));
            } else if (Expr.charAt(i) == br2) { // закрывающая скобка
                if (stack.head == null)
                    OK = 0;
                else {
                    char upper = stack.Pop();
                    if (upper != br1)
                        OK = 0;
                }
            }

        }

        if ((stack.head == null) & (OK == 1)) {
            return true;
        } else {
            return false;
        }

    }
}