package cs121;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeDemo {

    public static boolean isPalindrome(String input){
        boolean debug = false;
        final String lower = input.toLowerCase();
        if (debug) {
            System.out.printf("\nlower=\"%s\"\n", lower);
        }
        final String noSpaces = PalindromeHelper.keepOnlyLetters(lower);
        if (debug) {
            System.out.printf("noSpace=\"%s\"\n", noSpaces);
        }
        final char[] normalArray = PalindromeHelper.stringToArray(noSpaces);
        if (debug) {
            System.out.printf("normalArray=%s\n", Arrays.toString(normalArray));
        }
        final char[] reversedArray = PalindromeHelper.reverseArray(normalArray);
        if (debug) {
            System.out.printf("reversedArray=%s\n", Arrays.toString(reversedArray));
        }
        final String reversed = PalindromeHelper.arrayToString(reversedArray);
        if (debug) {
            System.out.printf("reversed=\"%s\"\n", reversed);
        }
        return noSpaces.equals(reversed);
    }

    static void checkIsPalindrome() {
        String[] palindromes = {
                "a", "racecar", "taco cat",
                "Racecar", "Madam, I'm Adam"
        };

        for (String p : palindromes) {
            if (isPalindrome(p)) {
                System.out.printf("Correct!: \"%s\" is a palindrome\n", p);
            } else {
                System.err.printf("Wrong!: \"%s\" *is* a palindrome\n", p);
            }
        }

        String[] notPalindromes = {
                "ab", "hello",
                "no, why"
        };
        for (String np : notPalindromes) {
            if (!isPalindrome(np)) {
                System.out.printf("Correct!: \"%s\" is not a palindrome\n", np);
            } else {
                System.err.printf("Wrong!: \"%s\" *is not* a palindrome\n", np);
            }
        }
    }

    public static void main(String[] args) {
        checkIsPalindrome();

        Scanner keyboard = new Scanner(System.in);
        while(true) {
            System.out.print("\nInput potential palindrome: ");
            String input = keyboard.nextLine();
            if (input.isBlank()) {
                break;
            }

            System.out.printf("\"%s\" %s a palindrome\n",
                    input, isPalindrome(input) ? "is": "is not");
        }
    }
}
