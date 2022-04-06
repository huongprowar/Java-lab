
package utilities;

import java.util.Scanner;


public class Input {


    public static int getIntegerExclusive(String msg, int min, int max) {
        return getInteger(msg, (value) -> {
            if (min < value && value < max) {
                return true;
            }
            System.err.println("Out of range: (" + min + ", " + max + ")");
            return false;
        });
    }


    public static int getIntegerInclusive(String msg, int min, int max) {
        return getInteger(msg, (value) -> {
            if (min <= value && value <= max) {
                return true;
            }
            System.err.println("Out of range: [" + min + ", " + max + "]");
            return false;
        });
    }


    public static int getInteger(String msg) {
        return getInteger(msg, null);
    }


    public static int getInteger(String msg, ValidationChecker<Integer> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("You must enter an integer");
            }
        }
    }


    public static float getFloatExclusive(String msg, float min, float max) {
        return getFloat(msg, (value) -> {
            if (min < value && value < max) {
                return true;
            }
            System.err.println("Out of range: (" + min + ", " + max + ")");
            return false;
        });
    }


    public static float getFloatInclusive(String msg, float min, float max) {
        return getFloat(msg, (value) -> {
            if (min <= value && value <= max) {
                return true;
            }
            System.err.println("Out of range: [" + min + ", " + max + "]");
            return false;
        });
    }


    public static float getFloat(String msg) {
        return getFloat(msg, null);
    }


    public static float getFloat(String msg, ValidationChecker<Float> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                float result = Float.parseFloat(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("You must enter a floating-point number");
            }
        }
    }


    public static double getDoubleExclusive(String msg, double min, double max) {
        return getDouble(msg, (value) -> {
            if (min < value && value < max) {
                return true;
            }
            System.err.println("Out of range: (" + min + ", " + max + ")");
            return false;
        });
    }


    public static double getDoubleInclusive(String msg, double min, double max) {
        return getDouble(msg, (value) -> {
            if (min <= value && value <= max) {
                return true;
            }
            System.err.println("Out of range: [" + min + ", " + max + "]");
            return false;
        });
    }

    public static double getDouble(String msg) {
        return getDouble(msg, null);
    }

    public static double getDouble(String msg, ValidationChecker<Double> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("You must enter a floating-point number");
            }
        }
    }

    public static String getString(String msg, ValidationChecker<String> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();
            if (checker == null || checker.checker(result)) {
                return result;
            }
        }
    }

    public static String getString(String msg) {
        return getString(msg, "");
    }


    public static String getString(String msg, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();
            if (regex.isEmpty() || result.matches(regex)) {
                return result;
            }
            System.err.println("Your string entered not match with regex");
        }
    }

    public static boolean getBoolean(String msg, String trueValues, String falseValues) {
        String[] trues = trueValues.split("\\|");
        String[] falses = falseValues.split("\\|");

        if (trues.length == 0) {
            return false;
        }

        if (falses.length == 0) {
            return true;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();

            for (String aTrue : trues) {
                if (result.equalsIgnoreCase(aTrue)) {
                    return true;
                }
            }

            for (String aFalse : falses) {
                if (result.equalsIgnoreCase(aFalse)) {
                    return false;
                }
            }

            System.err.println("Your string entered not match with any value");
        }
    }

    public static boolean getBoolean(String msg) {
        return getBoolean(msg, "y|yes|ok|yep|1", "n|no|nop|nope|0");
    }
}
