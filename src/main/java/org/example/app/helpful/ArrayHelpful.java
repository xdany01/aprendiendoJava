package org.example.app.helpful;

import java.lang.reflect.Array;
import java.util.StringJoiner;

public class ArrayHelpful {

    private static final int MIN_WIDTH = 3;
    private static final int MAX_INDEX = 9_999_999;
    private static final String DASH = "═";
    private static final String CYAN = ColorsCode.CYAN;
    private static final String GREEN = ColorsCode.GREEN;
    private static final String RESET = ColorsCode.RESET;

    public static void printStringAsArray(String str) {
        printStringAsArray(str, "");
    }

    public static void printStringAsArray(String str, String prefix) {
        if (str == null) {
            IO.println("null");
            return;
        }
        if (str.length() - 1 > MAX_INDEX) {
            IO.println(str);
            return;
        }
        printTopBorder(str.length(), prefix);
        printValues(str);
        printBottomBorder(str.length(), prefix);
        IO.println(RESET);
    }

    private static void printTopBorder(int length, String prefix) {
        IO.print(CYAN + "╔");
        for (int i = 0; i < length; i++) {
            int width = getWidth(i, prefix);
            IO.print(DASH.repeat(width));
            IO.print("╗");
            if (i < length - 1) {
                IO.print("╔");
            }
        }
        IO.println();
    }

    private static void printValues(String str) {
        for (int i = 0; i < str.length(); i++) {
            int width = getWidth(i);
            int leftPad = (width - 1) / 2;
            int rightPad = width - 1 - leftPad;
            IO.print("║" + RESET);
            IO.print(" ".repeat(leftPad));
            IO.print(str.charAt(i));
            IO.print(" ".repeat(rightPad));
            IO.print(CYAN + "║");
        }
        IO.println();
    }

    private static void printBottomBorder(int length, String prefix) {
        for (int i = 0; i < length; i++) {
            String index = prefix + i;
            int width = getWidth(i, prefix);
            int dashes = width - index.length();
            IO.print(CYAN + "╚" + GREEN);
            IO.print(index);
            IO.print(CYAN + DASH.repeat(dashes));
            IO.print("╝");
        }
    }

    public static void printArray(Object array) {
        if (array == null) {
            IO.println("null");
            return;
        }
        if (!array.getClass().isArray()) {
            IO.println(array);
            return;
        }
        printArray(array, "");
    }

    private static void printArray(Object array, String prefix) {
        int length = Array.getLength(array);
        if (length == 0) {
            IO.println("[]");
            return;
        }
        Object firstElement = Array.get(array, 0);
        if (firstElement != null && firstElement.getClass().isArray()) {
            for (int i = 0; i < length; i++) {
                Object child = Array.get(array, i);
                printArray(child, prefix + i + ".");
            }
            return;
        }
        printArrayRow(array, prefix);
    }

    private static void printArrayRow(Object array, String prefix) {
        int length = Array.getLength(array);
        printRowTopBorder(length, prefix);
        printRowValues(array);
        printRowBottomBorder(length, prefix);
        IO.println(RESET);
    }

    private static void printRowTopBorder(int length, String prefix) {
        IO.print(CYAN + "╔");
        for (int i = 0; i < length; i++) {
            int width = getWidth(i, prefix);
            IO.print(DASH.repeat(width));
            IO.print("╗");
            if (i < length - 1) {
                IO.print("╔");
            }
        }
        IO.println();
    }

    private static void printRowValues(Object array) {
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object value = Array.get(array, i);
            int width = getWidth(i);
            String text = String.valueOf(value);
            width = Math.max(width, text.length());
            int leftPad = (width - text.length()) / 2;
            int rightPad = width - text.length() - leftPad;
            IO.print("║" + RESET);
            IO.print(" ".repeat(leftPad));
            IO.print(text);
            IO.print(" ".repeat(rightPad));
            IO.print(CYAN + "║");
        }
        IO.println();
    }

    private static void printRowBottomBorder(int length, String prefix) {
        for (int i = 0; i < length; i++) {
            String index = prefix + i;
            int width = getWidth(i, prefix);
            width = Math.max(width, String.valueOf(Array.getLength(new Object[]{i})).length());
            int dashes = Math.max(0, width - index.length());
            IO.print(CYAN + "╚" + GREEN);
            IO.print(index);
            IO.print(CYAN + DASH.repeat(dashes));
            IO.print("╝");
        }
    }

    private static int getWidth(int index) {
        return Math.max(MIN_WIDTH, String.valueOf(index).length());
    }

    private static int getWidth(int index, String prefix) {
        return Math.max(MIN_WIDTH, prefix.length() + String.valueOf(index).length());
    }

    public static <T> String arrayToString(T[] arr) {
        return arrayToString(arr, "");
    }

    public static <T> String arrayToString(T[] arr, String separator) {
        if (arr == null) {
            return "null";
        }
        StringJoiner joiner = new StringJoiner(separator);
        for (T item : arr) {
            joiner.add(String.valueOf(item));
        }
        return joiner.toString();
    }
}
