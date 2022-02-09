package cs121;

import java.util.Arrays;

public class PalindromeChecker {
    static boolean verbose = true;

    private static boolean arraysSame(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int index=0; index<a1.length; index++) {
            if (a1[index] != a2[index]) {
                return false;
            }
        }
        return true;
    }

    public static void checkString2Array() {
        String[] inputs = {"", "ab", "hello"};
        char[][] expectedResults = {{}, {'a', 'b'}, {'h', 'e', 'l', 'l', 'o'}};
        boolean passing = true;
        for (int index = 0; index<inputs.length; index++) {
            char[] actualResult = PalindromeHelper.stringToArray(inputs[index]);
            if (arraysSame(expectedResults[index], actualResult)) {
                if (verbose) {
                    System.out.printf("stringToArray(\"%s\"), Expected: %s, got %s\n",
                            inputs[index],
                            Arrays.toString(expectedResults[index]),
                            Arrays.toString(actualResult));
                    System.out.flush();
                }
            } else {
                passing = false;
                System.err.printf("stringToArray(\"%s\"), Expected: %s, got %s\n",
                        inputs[index],
                        Arrays.toString(expectedResults[index]),
                        Arrays.toString(actualResult));
                System.err.flush();
            }
        }

        if (!passing) {
            System.err.println("checkString2Array failed\n");
            System.err.flush();
        }
    }

    public static void checkArray2String() {
        String[] expectedResults = {"", "ab", "hello"};
        char[][] inputs = {{}, {'a', 'b'}, {'h', 'e', 'l', 'l', 'o'}};
        boolean passing = true;
        for (int index = 0; index<inputs.length; index++) {
            String actualResult = PalindromeHelper.arrayToString(inputs[index]);
            if (expectedResults[index].equals(actualResult)) {
                if (verbose) {
                    System.out.printf("arrayToString(%s), Expected: \"%s\", got \"%s\"\n",
                            Arrays.toString(inputs[index]),
                            expectedResults[index],
                            actualResult);
                    System.out.flush();
                }
            } else {
                passing = false;
                System.err.printf("arrayToString(%s), Expected: \"%s\", got \"%s\"\n",
                        Arrays.toString(inputs[index]),
                        expectedResults[index],
                        actualResult);
                System.err.flush();
            }
        }

        if (!passing) {
            System.err.println("checkArray2String failed\n");
        }
    }

    public static void checkReverseArray() {
        char[][] expectedResults = {{}, {'a'}, {'b', 'a'}, {'o', 'l', 'l', 'e', 'h'}};
        char[][] inputs = {{}, {'a'}, {'a', 'b'}, {'h', 'e', 'l', 'l', 'o'}};
        boolean passing = true;

        for (int index = 0; index<inputs.length; index++) {
            char[] actualResult = PalindromeHelper.reverseArray(inputs[index]);
            if (arraysSame(expectedResults[index], actualResult)) {
                if (verbose) {
                    System.out.printf("reverseArray(%s), Expected: %s, got %s\n",
                            Arrays.toString(inputs[index]),
                            Arrays.toString(expectedResults[index]),
                            Arrays.toString(actualResult));
                    System.out.flush();
                }
            } else {
                passing = false;
                System.err.printf("reverseArray(%s), Expected: %s, got %s\n",
                        Arrays.toString(inputs[index]),
                        Arrays.toString(expectedResults[index]),
                        Arrays.toString(actualResult));
                System.err.flush();
            }
        }

        if (!passing) {
            System.err.println("checkReverseArray failed\n");
            System.err.flush();
        }
    }

    public static void checkKeepOnlyLetters() {
        String[] inputs =
                {"", " ", "a", "ab", " ab", "a b", "ab ", "a'b"};
        String[] expectedResults =
                {"", "", "a", "ab", "ab", "ab", "ab", "ab"};

        boolean passing = true;

        for (int index = 0; index<inputs.length; index++) {
            String actualResult = PalindromeHelper.keepOnlyLetters(inputs[index]);
            if (expectedResults[index].equals(actualResult)) {
                if (verbose) {
                    System.out.printf("keepOnlyLetters(\"%s\"), Expected: \"%s\", got \"%s\"\n",
                            inputs[index],
                            expectedResults[index],
                            actualResult);
                    System.out.flush();
                }
            } else {
                passing = false;
                System.err.printf("keepOnlyLetters(\"%s\"), Expected: \"%s\", got \"%s\"\n",
                        inputs[index],
                        expectedResults[index],
                        actualResult);
                System.err.flush();
            }
        }

        if (!passing) {
            System.err.println("checkRemoveWhitespace failed\n");
            System.err.flush();
        }
    }

    public static void main(String[] args) {
        try {
            checkString2Array();
        } catch (Exception e) {
            System.err.printf("checkString2Array threw %s\n", e);
            e.printStackTrace();
        }

        try {
            checkArray2String();
        } catch (Exception e) {
            System.err.printf("checkArray2String threw %s\n", e);
            e.printStackTrace();
        }

        try {
            checkReverseArray();
        } catch (Exception e) {
            System.err.printf("checkReverseArray threw %s\n", e);
            e.printStackTrace();
        }

        try {
            checkKeepOnlyLetters();
        } catch (Exception e) {
            System.err.printf("checkKeepOnlyLetters threw %s\n", e);
            e.printStackTrace();
        }
    }
}
