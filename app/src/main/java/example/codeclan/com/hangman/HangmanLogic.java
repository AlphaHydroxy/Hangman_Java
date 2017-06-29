package example.codeclan.com.hangman;

import java.util.Scanner;

/**
 * Created by user on 28/06/2017.
 */

public class HangmanLogic {

    private Scanner sc;

    public void playGame(AnswerWord answer, LetterPicker letterplayer) {

    boolean gameisFinished = !answer.wordComplete(answer.guessLetter(letterplayer.getGuesses()));

        while (letterplayer.getLives() > 0 && !gameisFinished) {
            letterplayer.pickLetter(answer);
            System.out.println(answer.guessLetter(letterplayer.getGuesses()));

        if (letterplayer.getLives() == 0) {
            System.out.println("Out of lives!");
            System.out.println("The correct answer was:");
            System.out.println(answer.getAnswer());
            System.exit(0);
        }

        if (!answer.guessLetter(letterplayer.getGuesses()).contains("_")) {
            System.out.println("You won!");
            System.out.println("The correct answer was:");
            System.out.println(answer.getAnswer());
            System.out.println("Would you like to play another game? (yes/no)");
            String input = sc.nextLine().toLowerCase();
            input = sc.nextLine();
            System.exit(0);
        }

    }
}

    public AnswerWord pickAnswerWord(WordChooser wordplayer){
        AnswerWord word = new AnswerWord(wordplayer.chooseWord());
        return word;
    }

    public boolean checkNotBlank(String input){
        return (input.length() != 0);
    }
}
