package string;

import java.util.*;

public class JString {
    
    public static void main(String[] args) {
        JString jString = new JString();

        System.out.println("---About String---");
        System.out.println("1 - Explain Immutable String");
        System.out.println("2 - Show result comparison String Object and String Literal");
        System.out.println("3 - Show result comparison String and StringBuffer and StringBuilder");
        System.out.print("Input the number: ");
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        switch (Integer.parseInt(input)) {
            case 1:
                System.out.println("---Explain Immutable String---");
                jString.explainImmutableString();
                break;
            case 2:
                System.out.println("---Comparison String Object and String Literal---");
                jString.comparisonObjectAndLiteral();
                break;
            case 3:
                System.out.println("---Comparison String and StringBuffer and StringBuilder---");
                jString.comparisonTime();
                break;
            default:
                break;
        }
    }

    /**
     * Comparing Strings and their References
     * <p>
     * 1. equals() method: It compares values of string for equality. Return type is boolean. In almost all the situation you can use useObjects.equals().
     * <p>
     * 2. == operator: It compares references not values. Return type is boolean. == is used in rare situations where you know you’re dealing with interned strings.
     * <p>
     * 3. compareTo() method: It compares values lexicographically and returns an integer value that describes if first string is less than, equal to or greater than second string.
     * For example, if str1 and str2 are two string variables then if
     * <p>
     * str1 == str2 : return 0
     * str1 > str2 : return a positive value
     * str1 < str2 : return a negative value
     * <p>
     * Note: The positive and negative values returned by compareTo method is the difference of first unmatched character in the two strings.
     */
    private void explainImmutableString() {
//        String immutableStr = "Star";
//        immutableStr.concat("bucks");
//        System.out.printf("Non Assign: %s\n", immutableStr);
//
//        immutableStr = immutableStr.concat("bucks");
//        System.out.printf("Assign: %s\n", immutableStr);

        String s1 = "Ram";
        String s2 = "Ram";
        String s3 = new String("Ram");
        String s4 = new String("Ram");
        String s5 = "Shyam";
        String nulls1 = null;
        String nulls2 = null;

        System.out.println("Comparing strings with equals:");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s5));
        // System.out.println(nulls1.equals(nulls2));  // NullPointerException

        System.out.println("Comparing strings with ==:");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(nulls1 == nulls2);

        System.out.println("Comparing strings with compareto:");
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s5));
        // System.out.println(nulls1.compareTo(nulls2));  // NullPointerException
    }

    private void comparisonObjectAndLiteral() {
        // boolean equals(String str): Case sensitive comparison
        // boolean equalsIgnoreCase(String str): Case in-sensitive comparison
        String strObject = new String("Java");
        String strLiteral = "Java";
        System.out.printf("String Object: %s --- String Literal: %s --- isEquals: %s --- Comparison: %s", strObject, strLiteral, strObject.equals(strLiteral), strObject == strLiteral);
    }

    private void comparisonTime() {
        long startTime = System.currentTimeMillis();
        String str = "Java";
        for (int i = 0; i < 1000; i++) {
            str += "Test";
        }
//        System.out.printf("Value: %s\n", str);
        System.out.printf("Time taken by String: %sms\n", (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append("Test");
        }
//        System.out.printf("Value: %s\n", stringBuffer);
        System.out.printf("Time taken by StringBuffer: %sms\n", (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("Test");
        }
//        System.out.printf("Value: %s\n", stringBuilder);
        System.out.printf("Time taken by StringBuilder: %sms\n", (System.currentTimeMillis() - startTime));
    }
}
