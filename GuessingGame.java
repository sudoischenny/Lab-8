import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField usrGuess;
  JLabel lblEnter;
  JLabel lblHelp;
  JLabel lblLast;
  Random rnum = new Random();
    int intRandom = rnum.nextInt(100) + 1;
  
  JButton guessButton = new JButton("Guess");
  JButton playAgainButton = new JButton("Play Again");
  GuessingGame() {


    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    usrGuess = new JTextField(10);
    usrGuess.setActionCommand("myTF");

    guessButton.setActionCommand("guessButton");
    playAgainButton.setActionCommand("playAgainButton");

    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    usrGuess.addActionListener(this);

    lblEnter = new JLabel("Enter your guess:");
    lblHelp = new JLabel("");
    lblLast = new JLabel("");

    frame.add(lblEnter);
    frame.add(usrGuess);
    frame.add(guessButton);
    frame.add(lblHelp);
    frame.add(lblLast);
    frame.add(playAgainButton);
    frame.setVisible(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed (ActionEvent ae){
    if (ae.getActionCommand().equals("guessButton")){
      int guess = Integer.parseInt(usrGuess.getText());
      lblLast.setText("Last guess was: " + guess); 
      if(guess < intRandom) {
      lblHelp.setText("Guess higher!");
      }
      else if(guess > intRandom) {
      lblHelp.setText("Guess lower!");
      }
      else if(guess == intRandom){
        lblHelp.setText("You got it!");
      }
    }
    else if(ae.getActionCommand().equals("playAgainButton")){
      Random rnum = new Random();
      intRandom = rnum.nextInt(100) + 1;
      lblHelp.setText("");
      lblLast.setText("");
      usrGuess.setText("");
    }
    else{
      lblHelp.setText("You pressed Enter. Please press the Guess Button");
    }
  }
}