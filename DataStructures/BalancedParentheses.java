package DataStructures;

/**
 * @author tushar.kasturi_ymedi this class implements method to check whether
 *         parathenses are balanced in arithmetic expression
 * @param <T>
 */
public class BalancedParentheses<T> {

	Stack<Character> stack = new Stack<>();

	/**
	 * @param expr is the arithmetic expression that needs to be checked this method
	 *             checks if exp is balanced
	 */
	public void isBalanced(String expr) {

		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {

				stack.push(expr.charAt(i));

			} else if (expr.charAt(i) == ')') {

				stack.pop();

			}
		}

		if (stack.isEmpty()) {
			System.out.println("Arithmetic Expression is Balanced");
		} else {
			System.out.println("Arithmetic Expression is not balanced");
		}

	}

	public static void main(String[] args) {
		String expr = "((3*4)+(4-2))/(4+9)";
		BalancedParentheses balancedParentheses = new BalancedParentheses();
		balancedParentheses.isBalanced(expr);
	}

}
