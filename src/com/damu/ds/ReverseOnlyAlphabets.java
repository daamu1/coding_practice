import java.util.Scanner;

public class ReverseOnlyAlphabets {
    public static String reverseAlphabets(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Move left forward if it's not an alphabet
            while (left < right && !Character.isLetter(arr[left])) {
                left++;
            }
            // Move right backward if it's not an alphabet
            while (left < right && !Character.isLetter(arr[right])) {
                right--;
            }
            // Swap only alphabetic characters
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking string input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();  // Reads the full input line

        // Calling the method
        String reversed = reverseAlphabets(input);

        // Printing the result
        System.out.println("Reversed String: " + reversed);

        sc.close();  // Closing scanner
    }
}
