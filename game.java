import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        String answer = Words.getWord();
        Scanner stdin = new Scanner(System.in);
        boolean revealed[] = new boolean[answer.length()];
        String input = "";
        char cinput = '0';
        int livesLeft = 7;
        boolean game = true;
        char letters[] = new char[26];
        int index = 0;

        for (int i = 0; i < revealed.length; i++) {
            if (revealed[i] == true) {
                System.out.print (answer.charAt(i) + " ");
            } else {
                System.out.print ("- ");
            }
        }
        System.out.println ();
        while (game) {
            boolean present = false;
            System.out.print ("Guess a letter! ");
            input = stdin.nextLine();
            cinput = input.charAt(0);
            index++;
            
        //checks if guessed letter is in the secret word
            for (int i = 0; i < answer.length(); i++) {
                if (cinput == answer.charAt(i)) {
                    revealed[i] = true;
                    present = true;
                } 
            }
        //takes a life if wrong letter is guessed    
            if (guessed (cinput, letters, index)) {
                System.out.println ("You already guessed that letter!");
            } else if (present == false) {
                livesLeft = livesLeft - 1;
            }
        //prints letters in the secret word that is guessed right
            for (int i = 0; i < revealed.length; i++) {
            if (revealed[i] == true) {
                System.out.print (answer.charAt(i) + " ");
            } else {
                System.out.print ("- ");
            }
            }
            System.out.println();
            System.out.println("Lives Left: " + livesLeft);
            game = play (livesLeft, revealed,answer);
            //prints letters guessed
            if (game == true) {
                System.out.print ("Letters Guessed:");
                for (int i = 0; i < letters.length; i++) {
                System.out.print (letters[i] + " ");
                }
                System.out.println();
            }
        }
    }
    
    //checks if the letter has been guessed before
    public static boolean guessed(char letter, char arr[], int index) {
        boolean present = false;
        for (int i = 0; i < arr.length; i++) {
            if (letter == arr[i]) {
                present = true;
            } 
        }
        if (present == false) {
            arr[index] = letter;
        }
        
        return present;
    }
    //check if player has won or lost the game
    public static boolean play(int livesLeft, boolean revealed[], String answer) {
        boolean play = true;        
        if (livesLeft == 0) {
                play = false;
                System.out.println ("Nice Try! The word was " + answer);
            }
            
        boolean won = true;
        for (int i = 0; i < revealed.length; i++) {
            if (revealed[i] == false) {
                won = false;
            }
        }
        if (won == true) {
            System.out.println ("CONGRATS!! You guessed correctly!");
            play = false;
        }
        return play;
    }
}