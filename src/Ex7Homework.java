import java.util.Random;
import java.util.Scanner;

public class Ex7Homework {
    public static final int LEVEL_ONE = 1;
    public static final int LEVEL_TWO = 2;
    public static final int LEVEL_THREE = 3;
    public static final int SURPRISE_LEVEL = 4;
    public static final int LEVEL_ONE_GUESSES = 20;
    public static final int LEVEL_TWO_GUESSES = 15;
    public static final int LEVEL_THREE_GUESSES = 10;
    public static final int PASSWORD_LENGTH = 4;
    public static final int BOUND = 6;
    public static final int RESULTS_LENGTH = 6;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String password = createPassword();
        int difficultyLevel;
        int numberOfGuesses = 0;
        do {
            System.out.println("Choose your desired level difficulty: ");
            System.out.println("Level 1 : 20 tries  press 1");
            System.out.println("Level 2 : 15 tries press 2");
            System.out.println("Level 3 : 10 tries press 3");
            System.out.println("Surprise level : 5-25 tries press 4");
            difficultyLevel = scanner.nextInt();
        } while (difficultyLevel < LEVEL_ONE || difficultyLevel > SURPRISE_LEVEL);

        switch (difficultyLevel){
            case LEVEL_ONE:
                numberOfGuesses = LEVEL_ONE_GUESSES;
                System.out.println("You have " + LEVEL_ONE_GUESSES + " tries");
                break;
            case LEVEL_TWO:
                numberOfGuesses = LEVEL_TWO_GUESSES;
                System.out.println("You have " + LEVEL_TWO_GUESSES + " tries");
                break;
            case LEVEL_THREE:
                numberOfGuesses = LEVEL_THREE_GUESSES;
                System.out.println("You have " + LEVEL_THREE_GUESSES + " tries");
                break;
            case SURPRISE_LEVEL:
                numberOfGuesses = random.nextInt(21) + 5;
                System.out.println("surprise: " + numberOfGuesses);
                break;
        }
        game(numberOfGuesses, password);

    }

    public static void game(int numberOfGuesses, String password){
        Scanner str = new Scanner(System.in);
        int[] results;
        for (int i = 0; i < numberOfGuesses; i++){
            String userGuess = "";
            do {
                System.out.println("Enter your guess (" + (i + 1) + "): ");
                userGuess = str.nextLine();
                if (fine(userGuess)){
                    i += 2;
                }
            } while (invalidGuess(userGuess));

            results = checkGuess(password, userGuess);
            printResults(results);
        }

    }

    public static String createPassword(){
        String password = "";
        Random random = new Random();

        for (int i = 0; i < PASSWORD_LENGTH; i++){
            int numberForPassword;
            do {
                numberForPassword = random.nextInt(BOUND) + 1;
                System.out.println("number: " + numberForPassword);
            } while (isContain(password, numberForPassword));
            password += numberForPassword;
            System.out.println("password: " + password);
        }

        return password;
    }

    public static boolean invalidGuess(String userGuess){
        boolean fine = fine(userGuess);
        boolean length = false;
        boolean range = false;
        if (userGuess.length() != 4){
            length = true;
        }
        for (int i = 0; i < userGuess.length(); i++){
            String currentNumber = Character.toString(userGuess.charAt(i));
            int number = Integer.parseInt(currentNumber);
            if (number < 1 || number > 6){
                range = true;
            }
        }
        return fine || length || range;
    }

    public static int[] checkGuess(String password, String userGuess){
        int[] results = new int[RESULTS_LENGTH]; //
        int hit = 0;
        int near = 0;
        for (int i = 0; i < password.length(); i++){
            String currentGuess = Character.toString(userGuess.charAt(i));
            String currentPassword = Character.toString(password.charAt(i));
            if (currentGuess.equals(currentPassword)){
                hit++;
            } else if (password.contains(currentGuess)) {
                near++;
            }
        }
        results[0] = hit;
        results[1] = near;

        return results;
    }

    public static boolean fine(String userGuess){
        boolean fine = false;
        for (int i = 0; i < userGuess.length() - 1; i++){
            String currentGuess = Character.toString(userGuess.charAt(i));
            for (int j = i + 1; j < userGuess.length(); j++){
                String currentCheck = Character.toString(userGuess.charAt(j));
                if (currentGuess.equals(currentCheck)){
                    fine = true;
                    break;
                }
            }
        }
        return fine;
    }

    public static void printResults(int[] results){
        if (results[0] == 4){
            System.out.println("you win!!");
        } else {
            System.out.println("You have " + results[0] + " HIT & " + results[1] + " NEAR");
        }
    }

    public static boolean isContain(String digits, int numberToCheck){
        boolean isContain = false;
        String number = Integer.toString(numberToCheck);
        if (digits.contains(number)){
            isContain = true;
        }
        return isContain;
    }
}