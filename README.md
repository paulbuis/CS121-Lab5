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
* Madam I'm Adam

## Java method `isPalindrome`

If we had a `PalindromeHelper` class with a few `static` methods,
we could write an `isPalindrome()` method something
like:

```java
    public static boolean isPalindrome(String input){
        String lower = input.toLowerCase();
        String noSpaces = PalindromeHelper.keepOnlyLetters(lower);
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
We can write a method
in a separate class that looks
something like:
```java
    public static void checkString2Array() {
        String[] inputs = {"", "ab", "hello"};
        char[][] expectedResults = {{}, {'a', 'b'}, {'h', 'e', 'l', 'l', 'o'}};
        boolean passing = true;
        for (int index = 0; index<inputs.length; index++) {
            char[] actualResult = PalindromeHelper.stringToArray(inputs[index]);
            if (arraysSame(expectedResults[index], actualResult)) {
                System.out.printf("stringToArray(\"%s\"), Expected: %s, got %s\n",
                        inputs[index],
                        Arrays.toString(expectedResults[index]),
                        Arrays.toString(actualResult));
            } else {
                passing = false;
                System.err.printf("stringToArray(\"%s\"), Expected: %s, got %s\n",
                        inputs[index],
                        Arrays.toString(expectedResults[index]),
                        Arrays.toString(actualResult));
            }
        }

        if (!passing) {
            System.err.println("checkString2Array failed\n");
            System.err.flush();
        }
    }
```

This method will test the `StringToArray()` method
and check if its behavior is as expected.


Then, once we believe the functions are working
independently, we can write code to see if they
are working together. For example, something like:

```java
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
```

To gain insight as to what might be
going wrong *inside* `IsPalindrome()`
we need to modify it so that we can see
the values of the local variables
as they are being produced like:

```java
    public static boolean isPalindrome(String input){
        boolean debug = false;
        String lower = input.toLowerCase();
        if (debug) {
            System.out.printf("\nlower=\"%s\"\n", lower);
        }
        String noSpaces = PalindromeHelper.keepOnlyLetters(lower);
        if (debug) {
            System.out.printf("noSpace=\"%s\"\n", noSpaces);
        }
        char[] normalArray = PalindromeHelper.stringToArray(noSpaces);
        if (debug) {
            System.out.printf("normalArray=%s\n", Arrays.toString(normalArray));
        }
        char[] reversedArray = PalindromeHelper.reverseArray(normalArray);
        if (debug) {
            System.out.printf("reversedArray=%s\n", Arrays.toString(normalArray));
        }
        String reversed = PalindromeHelper.arrayToString(reversedArray);
        if (debug) {
            System.out.printf("reversed=\"%s\"\n", reversed);
        }
        return noSpaces.equals(reversed);
    }
```

Note that the `debug` flag allows us
to suppress this output once we are
no longer interested in it. If we set
its value to `false`, the output will
not appear when the program is run.

## Lab Assignment

Fetch my starter code from GitHub at

```
https://github.com/paulbuis/CS121-Lab5.git
```

### Run individual function tests

Go to `src/main/java/cs121/PalidromeChecker.java`
and run it to see that the individual function tests
are failing.

### Fix `arrayToString()`

Find the `TODO` in `PalindromeHelper.arrayToString()`
and follow the directions.

### Re-Run `PalindromeChecker.main()`

Note if `arrayToString()` is working
now. If not, fix it and run the program
until it is.

### Fix `stringToArray()`

Find the `TODO` in `PalindromeHelper.stringToArray()`
and follow the directions.

### Re-Run `PalindromeChecker.main()`

Note if `stringToArray()` is working
now. If not, fix it and run the program
until it is.

### Swap roles

The pair programming pilot and navigator should swap
roles now.

### Fix `reverseArray()`

Find the `TODO` in `PalindromeHelper.reverseArray()`
and follow the directions.

### Re-Run `PalindromeChecker.main()`

Note if `reverseArray()` is working
now. If not, fix it and run the program
until it is.

### Run `PalindromeDemo.main()`

This is where we see if the individual
methods of `PalindromeHelper` work
together to solve the problem correctly.

Once, you verify that it does, you
can set `debug` to `false` in `isPalindrome()`
and remove the call to `checkIsPalindrome` in
`main` to run the program interactively.

