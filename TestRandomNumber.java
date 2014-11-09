import java.util.Scanner;

public class TestRandomNumber{
	static int randomAmount;
	static int randomRange;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the amount of random number: ");
		randomAmount = input.nextInt();
		System.out.print("Please enter the range of random number: ");
		randomRange = input.nextInt();

		int[] want = randomGenerateNumber();
		System.out.println(IntegerArrayToString(want));


	}
	static int[] randomGenerateNumber() {
		
		/**
		 *  Create a array to store the random number.
		 *  For loop can generate random number.
		 */
		int[] list = new int[randomAmount];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * randomRange) + 1;
		}

		/**
		 *  Checking the numbers whether are same or not.
		 *  case: have the same number(should random another number)
		 */
		int RepeatCount = 0;
		for (int i = 0; i < list.length; i++) {
			for (int k = 0; k < i; k++) {
				if(list[i] == list[k]){
					list[i] = (int)(Math.random() * randomRange) + 1;
					RepeatCount = RepeatCount + 1;
				}
			}
			if (RepeatCount > 0) {
				RepeatCount = 0;
				i = i - 1;
			}
		}

		return list;
	}

	static String IntegerArrayToString(int[] array){
		StringBuilder op = new StringBuilder();
		for(int i = 0; i < array.length; i++){
			op.append(array[i] + " ");
		}
		String op1 = new String(op);
		return op1;
	}
}
