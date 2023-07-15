import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "C:\\Users\\HOME\\OneDrive\\Documents\\Jumble_Game_Group7\\Final Project\\Final Java Program Project\\scoreFile.txt";
    private static String playerName;
    private static int lives = 5;
    private static int hints = 0;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("\n\n\tRegister Name: ");
        playerName = scan.nextLine();

        System.out.println("\n\t\tWelcome to Jumble Game " + playerName + "!" +
                "\n\n\tChallenge your word-solving abilities by unscrambling jumbled words. " +
                "\n\tRearrange the letters to guess the correct word within a limited number" +
                "\n\tof tries. With increasing difficulty, expand your vocabulary and compete" +
                "\n\twith others. Get ready for an addictive and challenging wordplay experience!");

        System.out.println("\n\t\t\t>> Press S to start the game");
        System.out.println("\t\t\t>> Press V to view records");
        System.out.println("\t\t\t>> Press Q to quit");

        Scanner sc = new Scanner(System.in);
        char choice = Character.toUpperCase(sc.next().charAt(0));

        if (choice == 'V') {
            records();
        } else if (choice == 'Q') {
            System.exit(0);
        } else if (choice == 'S') {
            game();
        } else {
            System.out.println("Invalid Option");
            System.exit(0);
        }
    }
    public static void game() {
        clear();
        System.out.println("\n\t\tWelcome to Jumble Game! " +
                "\n\tBefore we dive into the exciting word-solving adventure, " +
                "\n\tlet's choose the level of challenge that suits you best. " +
                "\n\tWould you like to play on the easy, medium, or hard level? " +
                "\n\tSelect your preferred difficulty and get ready to unravel some jumbled words!");

        System.out.print("\n\t1. Easy\n\t2. Medium\n\t3. Hard" +
                "\n\nChoose Difficulty: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num) {
            case 1:
                easy();
                break;
            case 2:
                medium();
                break;
            case 3:
                hard();
                break;
            default:
                System.out.println("Invalid Option. Input number 1, 2, or 3");
                game();
                break;
        }
    }
    public static void easy() {
        clear();
        System.out.println("\n\t\t\tWelcome to the Easy Level of Jumble Game! " +
                "\n\tEnjoy a delightful word-solving experience with relatively simple jumbled words. " +
                "\n\tUnscramble letters, build confidence, and expand your vocabulary. " +
                "\n\tLet's have fun unraveling words in the Easy Level of Jumble Game!");

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nPlease Enter to proceed...");
        sc.nextLine();

        String[] hintsEasy = {"Widely used programming language.", "Decides what to do if the condition is false" +
                            "a boolean value that is used when the result of a logical statement is false." +
                            "a boolean value that is used when the result of a logical statement is true" +
                            "used to represent text rather than numbers.", "function doesn't return a value" +
                            "common storage unit in a computer", "a collection of data stored in contiguous memory locations" +
                            "a value that a function returns", "converts values into floating point numbers"};
        String[] jumbledWords = {"AJAV", "SEELS", "FLSAE", "ETUR", "GSTIRN", "DIOV", "EFIL", "YRRAA", "RTERUN", "TFOAL"};
        String[] correctWords = {"JAVA", "ELSE", "FALSE", "TRUE", "STRING", "VOID", "FILE", "ARRAY", "RETURN", "FLOAT"};

        easyLevel(jumbledWords, correctWords, hintsEasy);
    }
    public static void easyLevel(String[] jumbledWords, String[] correctWords, String[] hints) {
        Scanner sc = new Scanner(System.in);
        int score = 0;


        for (int i = 0; i < jumbledWords.length; i++) {
            int guessCount = 0;
            while (guessCount < 3) {
                clear();
                System.out.println("\n\t\t Unscramble the word: " + jumbledWords[i]);
                System.out.println("\n\t\t\t>> Press H to get a hint (Lives: " + lives + ")");
                String userAnswer = sc.nextLine();

                if (userAnswer.equalsIgnoreCase("H")) {
                    if (hints[i].length() > 0) {
                        System.out.println("Hint: " + hints[i]);
                        lives--;
                        hints[i] = ""; // Remove the hint for the next attempt
                    } else {
                        System.out.println("No hints available!");
                    }
                } else if (userAnswer.equalsIgnoreCase(correctWords[i])) {
                    System.out.println("Correct!");
                    score++;
                    break; // Break out of the loop if the answer is correct
                } else {
                    System.out.println("Wrong!");
                    guessCount++;
                    if (guessCount < 3) {
                        System.out.println("Try again.");
                    } else {
                        System.out.println("Out of guesses! The correct answer is: " + correctWords[i]);
                    }
                }
            }

            if (lives <= 0) {
                System.out.println("Game over! You ran out of lives.");
                saveRecord("Easy", playerName, score, jumbledWords.length);
                option();
                return;
            }
        }

        saveRecord("Easy", playerName, score, jumbledWords.length);

        System.out.println("\nLevel finished! Your score: " + score + " out of " + jumbledWords.length);
        System.out.println("\n\t\tCongratulations on completing the Easy Level of Jumble Game! " +
                "\n\tYou've showcased your word-solving skills and successfully unraveled the jumbled words. " +
                "\n\tIf you're ready for a greater challenge, you can now progress to the Medium Level for a more engaging wordplay experience. " +
                "\n\tAlternatively, you can choose to play again at the Easy Level and continue honing your skills. " +
                "\n\tThe choice is yours! Thank you for playing Jumble Game, and we hope you had a fantastic time.");

        System.out.println("\n\t\t\t>> Press C to continue to the next level");
        System.out.println("\t\t\t>> Press V to view records");
        System.out.println("\t\t\t>> Press Q to quit");

        char choice = Character.toUpperCase(sc.next().charAt(0));

        if (choice == 'V') {
            records();
        } else if (choice == 'Q') {
            System.exit(1);
        } else if (choice == 'C') {
            medium();
        }
    }
    public static void medium() {
        clear();
        System.out.println("\n\t\t\tWelcome to the Medium Level of Jumble Game! " +
                "\n\tGet ready to elevate your word-solving skills to the next level. " +
                "\n\tIn this challenge, you'll encounter a mix of moderate difficulty " +
                "\n\tjumbled words that will put your knowledge and intuition to the test. " +
                "\n\tGet ready for an exhilarating wordplay adventure!");

        Scanner sca = new Scanner(System.in);
        System.out.println("\n\nPlease Enter to proceed...");
        sca.nextLine();

        String[] hintsMedium = {"arranges data vertically from top to bottom", "part of a class and is available to any obbject from that class." +
                "used in a function to refer to one of the pieces of data provided as input to the function." +
                "a pre designed value or setting that is not specified by the program user." +
                "one of five data types in programming", "it belongs to the class, rather than a specific instance." +
                "a set of integrated devices thta input, output, process, and store data and information", "contains code that accomplish a specific task" +
                "a value that is changeable", "an expression that evaluates to either true or false"};
        String[] jumbledWords2 = {"LCOMNU", "DTOHME", "EAAPMRETSR", "FEDLUTA", "CRESUTRTU", "TCTISA", "SMYTSE", "NUFITNOC", "EBRIVLA", "NABOOEL"};
        String[] correctWords2 = {"COLUMN", "METHOD", "PARAMETERS", "DEFAULT", "STRUCTURE", "STATIC", "SYSTEM", "FUNCTION", "VARIABLE", "BOOLEAN"};

        mediumLevel(jumbledWords2, correctWords2, hintsMedium);
    }
    public static void mediumLevel(String[] jumbledWords2, String[] correctWords2, String[] hints) {
        Scanner scn = new Scanner(System.in);
        int score2 = 0;

        for (int i = 0; i < jumbledWords2.length; i++) {
            int guessCount2 = 0;
            while (guessCount2 < 3) {
                clear();
                System.out.println("\n\t\tUnscramble the word: " + jumbledWords2[i]);
                System.out.println("\n\t\t\t>> Press H to get a hint (Lives: " + lives + ")");
                String userAnswer = scn.nextLine();

                if (userAnswer.equalsIgnoreCase("H")) {
                    if (hints[i].length() > 0) {
                        System.out.println("Hint: " + hints[i]);
                        lives--;
                        hints[i] = ""; // Remove the hint for the next attempt
                    } else {
                        System.out.println("No hints available!");
                    }
                } else if (userAnswer.equalsIgnoreCase(correctWords2[i])) {
                    System.out.println("Correct!");
                    score2++;
                    break; // Break out of the loop if the answer is correct
                } else {
                    System.out.println("Wrong!");
                    guessCount2++;
                    if (guessCount2 < 3) {
                        System.out.println("Try again.");
                    } else {
                        System.out.println("Out of guesses! The correct answer is: " + correctWords2[i]);
                    }
                }
            }

            if (lives <= 0) {
                System.out.println("Game over! You ran out of lives.");
                saveRecord("Medium", playerName, score2, jumbledWords2.length);
                option();
                return;
            }
        }

        saveRecord("Medium", playerName, score2, jumbledWords2.length);

        System.out.println("\nLevel finished! Your score: " + score2 + " out of " + jumbledWords2.length);
        System.out.println("\n\t\tCongratulations on completing the Easy Level of Jumble Game! " +
                "\n\tYou've showcased your word-solving skills and successfully unraveled the jumbled words. " +
                "\n\tIf you're ready for a greater challenge, you can now progress to the Medium Level for a more engaging wordplay experience. " +
                "\n\tAlternatively, you can choose to play again at the Easy Level and continue honing your skills. " +
                "\n\tThe choice is yours! Thank you for playing Jumble Game, and we hope you had a fantastic time.");

        System.out.println("\n\t\t\t>> Press C to continue to the next level");
        System.out.println("\t\t\t>> Press V to view records");
        System.out.println("\t\t\t>> Press Q to quit");

        char choice2 = Character.toUpperCase(scn.next().charAt(0));

        if (choice2 == 'V') {
            records();
        } else if (choice2 == 'Q') {
            System.exit(0);
        } else if (choice2 == 'C') {
            hard();
        }
    }
    public static void hard() {
        clear();
        System.out.println("\n\t\t\tWelcome to the Hard Level of Jumble Game! " +
                "\n\tTest your word-solving prowess with mind-boggling jumbled words. " +
                "\n\tChallenge your analysis, creativity, and vocabulary skills. " +
                "\n\tThis level is designed for the brave seeking an intense wordplay experience. " +
                "\n\tSharpen your problem-solving abilities and unlock satisfaction with each successfully deciphered word. " +
                "\n\tAre you ready to conquer the challenge of the Hard Level in Jumble Game?");

        Scanner sccn = new Scanner(System.in);
        System.out.println("\n\nPlease Enter to proceed...");
        sccn.nextLine();

        String[] hintsHard = {"Relating to or involving a process that repeats or calls itself within its own definition or structure." +
                "Elements or symbols used to alter or enhance the properties or behavior of other entities." +
                "pertaining to numbers or numerical values.", "Arranged or ordered in a sequence from highest to lowest." +
                "Safeguarded or secured from unauthorized access or damage.", "A whole number that does not include fractions or decimal points." +
                "A numerical data type that represents real numbers with both an integer part and a fractional part." +
                "Arranged or ordered in a sequence from lowest to highest.", "A collection of web pages or digital content accessible via the internet." +
                "A structured collection of data that is organized and stored in a computer system, typically for easy retrieval and management."};
        String[] jumbledWords3 = {"SIVERCRU", "RESIFIDOM", "REMILACUN", "GNIDNECSED", "TECTEROPD", "ENRIGET", "GINTFOLA", "GNISNECDA", "TIBEWES", "EDASABAT"};
        String[] correctWords3 = {"RECURSIVE", "MODIFIERS", "NUMERICAL", "DESCENDING", "PROTECTED", "INTEGER", "FLOATING", "ASCENDING", "WEBSITE", "DATABASE"};

        hardLevel(jumbledWords3, correctWords3, hintsHard);
    }
    public static void hardLevel(String[] jumbledWords3, String[] correctWords3, String[] hints) {
        Scanner scan = new Scanner(System.in);
        int score3 = 0;

        for (int i = 0; i < jumbledWords3.length; i++) {
            int guessCount3 = 0;
            while (guessCount3 < 3) {
                clear();
                System.out.println("\n\t\tUnscramble the word: " + jumbledWords3[i]);
                System.out.println("\n\t\t\t>> Press H to get a hint (Lives: " + lives + ")");
                String userAnswer = scan.nextLine();

                if (userAnswer.equalsIgnoreCase("H")) {
                    if (hints[i].length() > 0) {
                        System.out.println("Hint: " + hints[i]);
                        lives--;
                        hints[i] = ""; // Remove the hint for the next attempt
                    } else {
                        System.out.println("No hints available!");
                    }
                } else if (userAnswer.equalsIgnoreCase(correctWords3[i])) {
                    System.out.println("Correct!");
                    score3++;
                    break; // Break out of the loop if the answer is correct
                } else {
                    System.out.println("Wrong!");
                    guessCount3++;
                    if (guessCount3 < 3) {
                        System.out.println("Try again.");
                    } else {
                        System.out.println("Out of guesses! The correct answer is: " + correctWords3[i]);
                    }
                }
            }

            if (lives <= 0) {
                System.out.println("Game over! You ran out of lives.");
                saveRecord("Hard", playerName, score3, jumbledWords3.length);
                option();
                return;
            }
        }
        saveRecord("Hard", playerName, score3, jumbledWords3.length);

        System.out.println("\nLevel finished! Your score: " + score3 + " out of " + jumbledWords3.length);
        System.out.println("\n\t\tCongratulations on completing the Hard Level of Jumble Game! " +
                "\n\tYou've showcased your word-solving skills and successfully unraveled the challenging jumbled words. " +
                "\n\tYou've conquered the highest level of wordplay in Jumble Game, demonstrating your expertise in deciphering complex words. " +
                "\n\tThank you for playing Jumble Game, and we hope you had an amazing time!");

        System.out.println("\n\t\t\t>> Press V to view records");
        System.out.println("\t\t\t>> Press Q to quit");

        char choice3 = Character.toUpperCase(scan.next().charAt(0));

        if (choice3 == 'V') {
            records();
        } else if (choice3 == 'Q') {
            System.exit(0);
        }
    }
    public static void records() {
        try {
            File file = new File("C:\\Intellij\\JUMBLE WORD GAME\\scoreFile.txt");
            if (!file.exists()) {
                System.out.println("No records found.");
                return;
            }
            Scanner scanner = new Scanner(file);
            int totalScore = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

            }
            option();
            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the records.");
        }
    }

    public static void saveRecord(String level, String playerName, int score, int total) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Intellij\\JUMBLE WORD GAME\\scoreFile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Name: " + playerName + " | Level: " + level + " | Score: " + score + " out of " + total);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the record.");
        }
    }

    public static void option() {
        Scanner scans = new Scanner(System.in);
        System.out.println("\n\t\t\t>> Press P to play again");
        System.out.println("\t\t\t>> Press Q to quit");

        char choice3 = Character.toUpperCase(scans.next().charAt(0));

        if (choice3 == 'P') {
            game();
        } else if (choice3 == 'Q') {
            System.exit(0);
        }
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}



