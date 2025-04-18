import java.util.Scanner;

class randomgame {
    public static void main(String[] args) {
        int max = 100, min = 1;
        Scanner sc = new Scanner(System.in);
        int attempt = 10;
        int random;
        int play;
        int totalPoints = 0; 

        do {
            
            random = (int) (Math.random() * (max - min + 1)) + min;
            boolean isWinner = false;

            System.out.println("Guess the number between " + min + " and " + max + ":");

            for (int i = 0; i < attempt; i++) {
                int target = sc.nextInt();

                if (random == target) {
                    isWinner = true;
                    int pointsEarned = (attempt - i) * 10; 
                    totalPoints += pointsEarned;
                    System.out.println("You are the winner of this game!");
                    System.out.println("You earned " + pointsEarned + " points!");
                    break;
                } else if (random > target) {
                    System.out.println("You should guess a greater number.");
                } else {
                    System.out.println("You should guess a smaller number.");
                }
            }

            if (!isWinner) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + random);
            }

            System.out.println("Total Points: " + totalPoints);
            System.out.println("If you want to play again, press 1 to continue or 0 to exit.");
            play = sc.nextInt();
        } while (play == 1);

        System.out.println("Thank you for playing! Your total points: " + totalPoints);
        sc.close();
    }
}