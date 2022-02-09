# CS 121 - Lab 4

## Palindromes

A *palindrome* is a word, phrase, or sentence
that consists of the same sequence of letters
both in foreword and reverse orders.

*Examples:*

* racecar
* Racecar
* race car
* taco cat
* Madam Im Adam

## Java method `isPalindrome`

If we had a `PalindromeHelper` class with a few `static` methods,
we could write an `isPalindrome()` method something
like:

```java
    public static boolean isPalindrome(String input){
        String lower = input.toLowerCase();
        String noSpaces = PalindromeHelper.removeWhitespace(lower);
        char[] normalArray = PalindromeHelper.stringToArray(noSpaces);
        char[] reversedArray = PalindromeHelper.reverseArray(normalArray);
        String reversed = PalindromeHelper.arrayToString(reversedArray);
        return noSpaces.equals(reversed);
    }
```

If those methods of `PalindromeHelper` worked
correctly, we could demo our `isPalindrome` with
a `main()` like:

```java
class PalindromeDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.print("\nInput potential palindrome: ");
            String input = keyboard.nextLine();
            if (input.isBlank()) {
                break;
            }

            System.out.printf("\"%s\" %s a palindrome\n",
                    input, isPalindrome(input) ? "is" : "is not");
        }
    }
}
```

However, this demo will not help us
find which of the static methods of
PalindromeHelper are working, which are not, 
and what kind of behavior they
are exhibiting.

Instead, we can write tests to verify that
each of those methods are, in fact, working
correctly. And, if they are not, tests
should give us some idea what is going wrong.
