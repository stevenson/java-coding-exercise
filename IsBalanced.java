import java.io.*;
import java.util.*;

public class IsBalanced {
    Deque<Character> stack = new ArrayDeque<Character>();

    public static String isBalanced(String s) {
        // Write your code here
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            } else {
                char check;
                switch (x) {
                    case ')':
                        if(stack.isEmpty()){
                            return "NO";
                        }
                        check = stack.pop();
                        if (check == '{' || check == '[')
                            return "NO";
                        break;
                    case '}':
                        if(stack.isEmpty()){
                            return "NO";
                        }
                        check = stack.pop();
                        if (check == '(' || check == '[')
                            return "NO";
                        break;
                    case ']':
                        if(stack.isEmpty()){
                            return "NO";
                        }
                        check = stack.pop();
                        if (check == '(' || check == '{')
                            return "NO";
                        break;
                    default:
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        String s = "}][}}(}][))]";
        String result = isBalanced(s);
        System.out.println(result);
    }

    // 6
    // }][}}(}][))]
    // [](){()}
    // ()
    // ({}([][]))[]()
    // {)[](}]}]}))}(())(
    // ([[)

    // NO
    // YES
    // YES
    // YES
    // NO
    // NO
}
