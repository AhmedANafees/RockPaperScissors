
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author nafea8846
 */
public class RockPaperScissors  implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel title;
  JLabel wins;
  JLabel loses;
  JLabel ties;
  JButton rock;
  JButton paper;
  JButton scissors;
  JButton reset;
  JTextField result;
  JTextField wScore;
  JTextField lScore;
  JTextField tScore;
  int wNum = 0;
  int lNum = 0;
  int tNum = 0;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Rock Paper Scissors");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(400,400);
    // shows the window
    frame.setVisible(true);
 
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    
    title = new JLabel("Rock Paper Scissors");
    title.setBounds(50, 15, 150, 50);
    
    wins = new JLabel("Wins");
    wins.setBounds(85, 200, 100, 50);
    
    loses = new JLabel("Loses");
    loses .setBounds(280, 200, 100, 50);
    
    ties = new JLabel("Ties");
    ties.setBounds(185, 200, 50, 50);
    
    result = new JTextField();
    result.setBounds(50, 75, 300, 25);
    
    wScore = new JTextField();
    wScore.setBounds(75, 250, 50, 25);
    
    lScore = new JTextField();
    lScore.setBounds(275, 250, 50, 25);
    
    tScore = new JTextField();
    tScore.setBounds(175, 250, 50 ,25);
    
    rock = new JButton("Rock");
    rock.setBounds(50, 150, 100, 50);
    rock.addActionListener(this);
    rock.setActionCommand("rock");
    
    paper = new JButton("Paper");
    paper.setBounds(150, 150, 100, 50);
    paper.addActionListener(this);
    paper.setActionCommand("paper");
    
    scissors = new JButton("Scissors");
    scissors.setBounds(250, 150, 100, 50);
    scissors.addActionListener(this);
    scissors.setActionCommand("scissors");
    
    reset = new JButton("Reset");
    reset.setBounds(135, 325, 100, 25);
    reset.addActionListener(this);
    reset.setActionCommand("reset");
    
    mainPanel.add(tScore);
    mainPanel.add(ties);
    mainPanel.add(reset);
    mainPanel.add(lScore);
    mainPanel.add(wScore);
    mainPanel.add(loses);
    mainPanel.add(wins);
    mainPanel.add(result);
    mainPanel.add(title);
    mainPanel.add(scissors);
    mainPanel.add(paper);
    mainPanel.add(rock);
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    int lowest = 1;
    int highest = 3;

    int randomNumber = (int)(Math.random( )*(highest-lowest+1) + lowest);

    if (command.equals("rock"))
    {
        if (randomNumber == 3)
        {
            result.setText("You Win");
            wNum++;
        }
        else if (randomNumber == 1)
        {
        result.setText("It's a Tie");
        tNum++;
        }
        else
        {
            result.setText("You Lose");
            lNum++;
        }
        wScore.setText(" " + wNum);
        lScore.setText(" " + lNum);
        tScore.setText(" " + tNum);
    }
    
    if (command.equals("paper"))
    {
        if (randomNumber == 1)
        {
            result.setText("You Win");
            wNum++;
        }
        else if (randomNumber == 2)
        {
            result.setText("It's a Tie");
            tNum++;
        }
        else
        {
            lNum++;
            result.setText("You Lose");
        }
        wScore.setText(" " + wNum);
        lScore.setText(" " + lNum);
        tScore.setText(" " + tNum);
    }
    if (command.equals("scissors"))
    {
        if (randomNumber == 2)
        {
            wNum++;
            result.setText("You Win");
        }
        else if (randomNumber == 3)
        {
        result.setText("It's a Tie");
        tNum++;
        }
        else
        {
            lNum++;
            result.setText("You lose");
        }
        wScore.setText(" " + wNum);
        lScore.setText(" " + lNum);
        tScore.setText(" " + tNum);
    }
    
    if (command.equals("reset"))
    {
        wScore.setText(" ");
        lScore.setText(" ");
        result.setText(" ");
        wNum = 0;
        lNum = 0;
    }
        
        }
  

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    RockPaperScissors  gui = new RockPaperScissors ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

