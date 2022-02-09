package cs121;

public class PalindromeHelper {
    public static char[] stringToArray(String s) {
        if (s == null) {
            char[] empty = {};
            return empty;
        }
        char[] array = new char[s.length()];
        for (int index=0; index<s.length(); index++) {
            // TODO: copy chars from string to array
            //  This does *not* copy characters!
            array[index] = '-';  // replace this line *and* remove comments
        }
        return array;
    }

    public static String arrayToString(char[] array) {
        String s = "";
        if (array == null) {
            return s;
        }
        for (int index=0; index<array.length; index++) {
            // TODO: copy chars from array to string
            //  This does *not* make a copy!
            s = s + "+"; // replace this line and remove comments
        }
        return s;
    }

    public static char[] reverseArray(char[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int index=0; index<array.length; index++) {
            // TODO: reverse order of chars as they are copied to result
            //  This does *not* reverse the order!
            result[index] = array[index]; // replace this line and remove comments
        }
        return result;
    }

    public static String keepOnlyLetters(String input) {
        if (input == null) {
            return null;
        }
        char[] array = stringToArray(input);
        int letterCount = 0;
        for (char ch: array) {
            if (Character.isLetter(ch)) {
                letterCount++;
            }
        }
        char[] result = new char[letterCount];
        int arrayIndex = 0;
        int resultIndex = 0;
        while (arrayIndex < array.length) {
            if (Character.isLetter(array[arrayIndex])) {
                result[resultIndex] = array[arrayIndex];
                resultIndex++;
            }
            arrayIndex++;
        }
        return arrayToString(result);
    }
}
