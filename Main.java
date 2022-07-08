import java.util.Scanner;
import java.util.InputMismatchException;

import static java.lang.Integer.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("¬ведите пример ");
        String userInput = scanner.nextLine().toUpperCase();
        userInput = userInput.replaceAll("\\s", "");
        String regex = "^(\\d{1,3})[+-/*](\\d{1,3})$";
        try {
            if (userInput.matches(regex)) {
                calcArab(convert(userInput));
            } else {
                romanCalc(convert(userInput));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String convert(String userInput) {

        char[] underChar = new char[11];
        for (int i = 0; i < userInput.length(); i++) {
            underChar[i] = userInput.charAt(i);
            if (underChar[i] == '+') {
                operation = '+';
            }
            if (underChar[i] == '-') {
                operation = '-';
            }
            if (underChar[i] == '*') {
                operation = '*';
            }
            if (underChar[i] == '/') {
                operation = '/';
            }
        }
        return String.valueOf(underChar);
    }

    static String convertNumToRoman(int numArabian) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }


    public static void romanCalc(String underCharString) {
        String[] blocks = underCharString.split("[+-/*]");
        String stable00 = blocks[0].trim();
        String stable01 = blocks[1].trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(stable01);
        if (number1 > 10 || number1 < 1 || number2 > 10 || number2 < 1) {
            throw new IllegalArgumentException();
        }
        else {
            result = calculated(number1, number2, operation);
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
        }
    }

    public static void calcArab(String underCharString) {
        String[] blocks = underCharString.split("[+-/*]");
        String stable00 = blocks[0].trim();
        String stable01 = blocks[1].trim();
        number1 = parseInt(stable00);
        number2 = parseInt(stable01);
        if (number1 > 10 || number1 < 1 || number2 > 10 || number2 < 1) {
            throw new IllegalArgumentException();
        }
        result = calculated(number1, number2, operation);

        System.out.println(result);
    }

    private static int romanToNumber(String roman) {

        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        return -1;
    }

    private static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                    result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("неверный знак операции");
        }
        return result;
    }
}

