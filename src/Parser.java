import java.util.*;
import java.io.*;

public class Parser
{
    public static class BalancedBrackets
    {
        static boolean areBracketsBalanced(String expr)
        {
            Stack<Character> stack = new ArrayStack<Character>();

            for (int i = 0; i < expr.length(); i++)
            {
                char x = expr.charAt(i);

                if (x == '(' || x == '[' || x == '{' || x == '"')
                {
                    stack.push(x);
                    continue;
                }
                if (stack.isEmpty())
                    return false;
                char check;
                switch (x) {
                    case ')':
                        check = stack.pop();
                        if (check == '{' || check == '[' || check == '"')
                            return false;
                        break;

                    case '}':
                        check = stack.pop();
                        if (check == '(' || check == '[' || check == '"')
                            return false;
                        break;

                    case ']':
                        check = stack.pop();
                        if (check == '(' || check == '{' || check == '"')
                            return false;
                        break;
                    case '"':
                        check = stack.pop();
                        if (check == '(' || check == '{' || check == '[')
                            return false;
                        break;
                }
            }
            return (stack.isEmpty());
        }

        public static void main(String[] args)
        {
            String expr = "([{}])";

            // Function call
            if (areBracketsBalanced(expr))
                System.out.println("Well formed ");
            else
                System.out.println("Not well formed ");

        }
    }
}

