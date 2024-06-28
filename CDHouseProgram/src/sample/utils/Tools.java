package sample.utils;

import java.util.Scanner;

public class Tools {

    public static Scanner sc = new Scanner(System.in);

    //Tools for input data.
    public static String getString(String msg, boolean mayEmpty) {
        boolean check = true;
        String result = "";
        do {
            try {
                System.out.print(msg);
                result = sc.nextLine().trim();
                if (result.isEmpty() && mayEmpty == true) {
                    return null;
                }
                if (result.isEmpty()) {
                    System.out.println("Please input text!!!");
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        } while (check);
        return result;
    }

    public static int getInt(String msg, boolean mayEmpty) {
        boolean check = true;
        int number = 0;
        do {
            try {
                System.out.print(msg);
                String str = sc.nextLine().trim();
                if (mayEmpty && str.isEmpty()) {
                    return Integer.MIN_VALUE;
                }
                number = Integer.parseInt(str);
                if (number < 0) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        } while (check);
        return number;
    }

    public static double getDouble(String msg, boolean mayEmpty) {
        boolean check = true;
        double result = 0;
        do {
            try {
                System.out.print(msg);
                String str = sc.nextLine().trim();
                if (mayEmpty && str.isEmpty()) {
                    return Double.MIN_VALUE;
                }
                result = Double.parseDouble(str);
                if (result < 0) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        } while (check);
        return result;
    }

    public static int getInt(String msg, int min, int max) {
        int result = Integer.MIN_VALUE;
        while (result < min || result > max) {
            try {
                System.out.print(msg + "(from " + min + " to " + max + ")   ");
                result = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        }
        return result;
    }

    public static String cdType(String msg, boolean canEmpty) {
        String result = null;
        boolean cont = true;
        do {
            try {
                System.out.print(msg);
                result = sc.nextLine().trim().toLowerCase();
                if (result.isEmpty() && canEmpty) {
                    return null;
                }
                switch (result) {
                    case "audio":
                        return "audio";
                    case "video":
                        return "video";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Erorr. Try again.");
            }
        } while (cont);

        return result;
    }

    public static String cdCollectionName(String msg, boolean canEmpty) {
        String result = null;
        boolean cont = true;
        do {
            try {
                System.out.print(msg);
                result = sc.nextLine().toLowerCase().trim();
                if (result.isEmpty() && canEmpty) {
                    return null;
                }
                switch (result) {
                    case "game":
                        return "game";
                    case "movie":
                        return "movie";
                    case "music":
                        return "music";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Erorr. Try again.");
            }
        } while (cont);

        return result;
    }

    //Tools for taking user confirmation.
    public static boolean confirmYesNo(String msg) {
        boolean result = false;
        String confirm = Tools.getString(msg, false);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    //Tools for asking user to back to menu.
    public static boolean askBackToMenu() {
        boolean result = false;
        String userAnswer = "";
        System.out.print("Go back to main menu? (Y/N): ");
        boolean check = confirmYesNo(userAnswer); //Taking confirmation.
        if (check) {
            result = true;
        }
        return result;
    }
}
