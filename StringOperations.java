import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        String s1;
        int ch;
        int count = 0;
        Scanner m = new Scanner(System.in);
        System.out.println("Enter the String: ");
        s1 = m.nextLine();
        System.out.println("Enter Choice: ");
        System.out.println("1) Reverse the string\n2) Convert to uppercase\n3) Convert to lowercase\n4) Palindrome Check\n5) Count vowels");
        ch = m.nextInt();
        m.nextLine();
        String reversed = "";
        switch (ch) {
            case 1:
                System.out.println("The reverse of the String is: ");
                for (int i = s1.length() - 1; i >= 0; i--) {
                    reversed += s1.charAt(i);
                }
                System.out.println(reversed);
                break;
            case 2:
                System.out.println("The uppercase for the string is: " + s1.toUpperCase());
                break;
            case 3:
                System.out.println("The lowercase for the string is: " + s1.toLowerCase());
                break;
            case 4:
                for (int i = s1.length() - 1; i >= 0; i--) {
                    reversed += s1.charAt(i);
                }
                if (s1.equalsIgnoreCase(reversed)) {
                    System.out.println("The string is a palindrome.");
                } else {
                    System.out.println("The string is not a palindrome.");
                }
                break;
            case 5:
                for (int i = 0; i < s1.length(); i++) {
                    char c = s1.charAt(i);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        count++;
                    }
                }
                System.out.println("The total count of vowels in the string is: " + count);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
        m.close();
    }
}
