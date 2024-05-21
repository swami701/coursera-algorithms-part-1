package playground;

import Common.ArrayStack;

class MathExpressionSolver {
    public int getResultOfExpression(String expression) {
        ArrayStack arrayStack = new ArrayStack();
        return 0;
    }
}

public class DijikstraMathematicalExpression {
    public static void main(String[] args) {
        String expression = "((2+5)*6)";
        MathExpressionSolver mathExpressionSolver = new MathExpressionSolver();
        System.out.printf("Result: %s\n", mathExpressionSolver.getResultOfExpression(expression));
    }
}
