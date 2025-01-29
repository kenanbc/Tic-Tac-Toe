package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow {
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

    char wonSign = ' ';
    int playerOneScore = 0;
    int playerTwoScore = 0;
    public GameWindow(){
        //view.Style.setButtonStyle(innerPanel);
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
                buttonSet(button00);
                int num = stateOfSign ? 1 : 0;
                board[0][0] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button01);
                int num = stateOfSign ? 1 : 0;
                board[0][1] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button02);
                int num = stateOfSign ? 1 : 0;
                board[0][2] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button10);
                int num = stateOfSign ? 1 : 0;
                board[1][0] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button11);
                int num = stateOfSign ? 1 : 0;
                board[1][1] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button12);
                int num = stateOfSign ? 1 : 0;
                board[1][2] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button20);
                int num = stateOfSign ? 1 : 0;
                board[2][0] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button21);
                int num = stateOfSign ? 1 : 0;
                board[2][1] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSet(button22);
                int num = stateOfSign ? 1 : 0;
                board[2][2] = num;
                if(checkMatrix())
                    setResult();
                else
                    checkPossibleMoves();
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
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        board[i][j] = 2;
                    }
                }

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
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(new GameWindow().gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //openInputDialog();
    }

    private String switchSign(boolean stateOfSign){
        if(stateOfSign)
            return "O";
        else
            return "X";
    }

    private void buttonSet(JButton button){
        button.setEnabled(false);
        button.setText(switchSign(stateOfSign));
        stateOfSign = !stateOfSign;
    }

    private boolean checkMatrix(){
        int diagonalCounter = 0;
        int secondDiagonalCounter = 0;
        boolean rowState = false;
        boolean columnState = false;

        for (int i = 0; i < 3; i++) {
            if (board[i][i] == board[0][0] && (board[i][i] == 0 || board[i][i] == 1)) {
                diagonalCounter++;
            }
            if (board[i][2 - i] == board[0][2] && (board[i][2 - i] == 0 || board[i][2 - i] == 1)) {
                secondDiagonalCounter++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != board[i][0] || (board[i][j] != 0 && board[i][j] != 1)) {
                    rowState = false;
                    break;
                }
                rowState = true;
                wonSign = board[i][j] == 1 ?  'X' :  'O';
            }
            if(rowState)
                break;
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 1; i < 3; i++) {
                if (board[i][j] != board[0][j] || (board[i][j] != 0 && board[i][j] != 1)) {
                    columnState = false;
                    break;
                }
                columnState = true;
                wonSign = board[i][j] == 1 ?  'X' :  'O';
            }
            if(columnState)
                break;
        }

        if(diagonalCounter == 3){
            wonSign = board[0][0] == 1 ?  'X' :  'O';
        }
        else if(secondDiagonalCounter == 3){
            wonSign = board[0][2] == 1 ?  'X' :  'O';
        }

        return diagonalCounter == 3 || secondDiagonalCounter == 3 || rowState || columnState;
    }

    private void setResult(){
        if(wonSign == 'X'){
            resultLabel.setText("Player ONE won!");
            playerOneScore++;
            playerOneScoreLabel.setText(String.valueOf(playerOneScore));
        }else if(wonSign == 'O'){
            resultLabel.setText("Player TWO won!");
            playerTwoScore++;
            playerTwoScoreLabel.setText(String.valueOf(playerTwoScore));
        }
        Style.setTextColor(resultLabel, Color.decode("#5D8736"));
        Style.setBoldFont(resultLabel);
        resultLabel.setVisible(true);
        changeStateOfAllButtons(false);
    }

    private void checkPossibleMoves(){
        boolean isPossible = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2)
                    isPossible = true;
            }
        }

        if(!isPossible){
            resultLabel.setText("TIE");
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

//    private void openInputDialog() {
//        JTextField textField1 = new JTextField(10);
//        JTextField textField2 = new JTextField(10);
//
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new GridLayout(2, 2));
//        inputPanel.add(new JLabel("Name 1:"));
//        inputPanel.add(textField1);
//        inputPanel.add(new JLabel("Name 2:"));
//        inputPanel.add(textField2);
//
//        int result = JOptionPane.showConfirmDialog(
//                gamePanel,
//                inputPanel,
//                "Enter Names",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.PLAIN_MESSAGE
//        );
//
//        if (result == JOptionPane.OK_OPTION) {
//            playerOneLabel.setText(textField1.getText());
//            playerTwoLabel.setText(textField2.getText());
//        }
//    }
}
