package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow implements SetWonSign{
    private JPanel gamePanel;
    private JButton button00;
    private JButton button21;
    private JButton button22;
    private JButton button20;
    private JButton button11;
    private JButton button12;
    private JButton button10;
    private JButton button01;
    private JButton button02;
    private JPanel innerPanel;
    private JButton backButton;
    private JLabel vsLabel;
    private JLabel playerOneLabel;
    private JLabel playerTwoLabel;
    private JButton repeatButton;
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JLabel resultLabel;

    private boolean stateOfSign = false;
    private int[][] board = {  {2, 2, 2},
                                {2, 2, 2},
                                {2, 2, 2}
                            };

    private static char wonSign = ' ';
    int playerOneScore = 0;
    int playerTwoScore = 0;

    @Override
    public void setWonSign(char wonSign) {
        GameWindow.wonSign = wonSign;
    }

    public GameWindow(){

        Style.setBoldFont(playerOneLabel);
        Style.setBoldFont(playerTwoLabel);
        Style.setDefaultLabelFont(playerOneLabel);
        Style.setDefaultLabelFont(playerTwoLabel);

        Style.setBoldFont(playerOneScoreLabel);
        Style.setBoldFont(playerTwoScoreLabel);

        Style.setDefaultLabelFont(resultLabel);

        button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button00, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[0][0] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button01, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[0][1] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button02, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[0][2] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button10,stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[1][0] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button11, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[1][1] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button12, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[1][2] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button20, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[2][0] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button21, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[2][1] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOfSign = GameLogic.buttonSet(button22, stateOfSign);
                int num = stateOfSign ? 1 : 0;
                board[2][2] = num;
                if(GameLogic.checkMatrix(board, GameWindow.this))
                    setResult();
                else
                    setTieResult();
            }
        });
        repeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setVisible(false);
                button00.setText("");
                button01.setText("");
                button02.setText("");
                button10.setText("");
                button11.setText("");
                button12.setText("");
                button20.setText("");
                button21.setText("");
                button22.setText("");

                changeStateOfAllButtons(true);

                stateOfSign = false;
                wonSign = ' ';
                GameLogic.resetBoard(board);

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeWindow homeWindow = new HomeWindow();
                homeWindow.showHomeWindow();
                SwingUtilities.getWindowAncestor(gamePanel).dispose();
            }
        });
    }

    public void showGameWindow(){
        GameWindow gameWindow = new GameWindow();
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(gameWindow.gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gameWindow.openInputDialog();
    }

    private void openInputDialog() {
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1, 10, 10));
        inputPanel.add(new JLabel("Name 1:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Name 2:"));
        inputPanel.add(textField2);

        int result = JOptionPane.showConfirmDialog(
                gamePanel,
                inputPanel,
                "Enter Names",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            playerOneLabel.setText(textField1.getText());
            playerTwoLabel.setText(textField2.getText());
        }
    }

    private void setResult(){
        if(wonSign == 'X'){
            resultLabel.setText(playerOneLabel.getText() +" won!");
            playerOneScore++;
            playerOneScoreLabel.setText(String.valueOf(playerOneScore));
        }else if(wonSign == 'O'){
            resultLabel.setText(playerTwoLabel.getText() + " won!");
            playerTwoScore++;
            playerTwoScoreLabel.setText(String.valueOf(playerTwoScore));
        }
        Style.setTextColor(resultLabel, Color.decode("#5D8736"));
        Style.setBoldFont(resultLabel);
        resultLabel.setVisible(true);
        changeStateOfAllButtons(false);
    }

    private void setTieResult(){
        if(!GameLogic.isMovesLeft(board)){
            resultLabel.setText("TIE");
            Style.setTextColor(resultLabel, Color.RED);
            resultLabel.setVisible(true);
        }
    }

    private void changeStateOfAllButtons(boolean state){
        button00.setEnabled(state);
        button01.setEnabled(state);
        button02.setEnabled(state);
        button10.setEnabled(state);
        button11.setEnabled(state);
        button12.setEnabled(state);
        button20.setEnabled(state);
        button21.setEnabled(state);
        button22.setEnabled(state);
    }
}
