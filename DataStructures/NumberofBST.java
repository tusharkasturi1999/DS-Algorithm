package DataStructures;

/**
 * calculates number of BST
 * 
 * @author tushar.kasturi_ymedi
 *
 */
public class NumberofBST {
	/**
	 * @param num is the input number to find factorial
	 * @return the factorial of number this method calculates factorial using
	 *         recursion
	 */
	public static int factorial(int num) {

		int fact = 1;
		if (num == 0)
			return 1;
		return (num * factorial(num - 1));
	}

	/**
	 * numOfBST= (2n)! / n! *(n+1)! n=number of nodes
	 */
	public static void numOfBST(int numOfNode) {
		int catalanNumber = factorial(2 * numOfNode) / (factorial(numOfNode) * factorial(numOfNode + 1));
		System.out.println("Number of binary search tree with " + numOfNode + " node is " + catalanNumber);
	}

	public static void main(String[] args) {
		NumberofBST.numOfBST(3);
	}

}