package lecture12.exercises.rpm;

import java.util.Arrays;
import java.util.Stack;

public class RPMDemo {


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("*");
        stack.push("-");

        String item = stack.pop();

        handleItem(stack, item);

        System.out.println(Arrays.toString(stack.toArray()));
    }

    private static void handleItem(Stack<String> stack, String operator) {


        if (isOperator(operator)) {

            String operand2 = stack.pop();
            String operand1 = stack.pop();

            double value1 = Double.parseDouble(operand1);
            double value2 = Double.parseDouble(operand2);

            double result = handleOperator(value1, value2, operator);

            stack.push(Double.toString(result));
        }
    }

    private static double handleOperator(double value1, double value2, String operator) {
        if ("+".equals(operator)) {
            return value1 + value2;
        }

        if ("-".equals(operator)) {
            return value1 - value2;
        }

        if ("*".equals(operator)) {
            return value1 * value2;
        }

        return value1 / value2;
    }

    private static boolean isOperator(String item) {
        return "+".equals(item)
                || "-".equals(item)
                || "*".equals(item)
                || "/".equals(item);
    }


}
