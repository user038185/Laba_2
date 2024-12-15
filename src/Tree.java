import java.util.Scanner;

class Branch {
    char elem;
    Branch left;
    Branch right;
}

public class Tree {
    private Branch tree = null;

    Tree(String Expr) {
        tree = make_tree(Expr, 0, Expr.length() - 1);
    }

    Branch make_tree(String Expr, int first, int last) {
        int MinPrt, i, k = 0, prt;
        Branch tree = new Branch();
        if (first > last)
            return null;
        if (first == last) {
            if ((Expr.charAt(first) == '(') || (Expr.charAt(first) == ')'))
                return null;
            tree.elem = Expr.charAt(first);
            tree.left = null;
            tree.right = null;
            return tree;
        }

        if ((Expr.charAt(first) == '(') && (Expr.charAt(last) == ')')) {
            if (Expression.check_brackets(Expr.substring(first + 1, last))) {
                first++;
                last--;
            }
        }

        MinPrt = 5;
        int flag = 0;
        for (i = first; i <= last; i++) {
            if (Expr.charAt(i) == '(')
                flag++;
            else if (Expr.charAt(i) == ')')
                flag--;
            else if (flag == 0) {
                prt = Expression.Priority(Expr.charAt(i));
                if (prt <= MinPrt) {
                    MinPrt = prt;
                    k = i;
                }
            }
        }

        tree.elem = Expr.charAt(k);
        tree.left = make_tree(Expr, first, k - 1);
        tree.right = make_tree(Expr, k + 1, last);
        return tree;
    }

    Branch get_tree() {
        return tree;
    }

}