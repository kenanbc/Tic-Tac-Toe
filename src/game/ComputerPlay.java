package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerPlay implements SetWonSign{
    private JButton backButton;
    private JButton repeatButton;
    private JPanel innerPanel;
    private JPanel gamePanel;
    private JLabel computerScoreLabel;
    private JLabel playerScoreLabel;
    private JLabel playerLabel;
    private JLabel computerLabel;
    private JLabel resultLabel;
    private JLabel vsLabel;
    private JButton button00;
    private JButton button21;
    private JButton button22;
    private JButton button20;
    private JButton button01;
    private JButton button02;
    private JButton button10;
    private JButton button11;
    private JButton button12;


    private boolean stateOfSign = false;
    private int[][] board = {   {2, 2, 2},
                                {2, 2, 2},
                                {2, 2, 2}
    };

    private static char wonSign = ' ';
    int playerScore = 0;
    int computerScore = 0;

    @Override
    public void setWonSign(char wonSign) {
        ComputerPlay.wonSign = wonSign;
    }

    public ComputerPlay() {

        button01.setName("button01");

        Style.setBoldFont(playerLabel);
        Style.setBoldFont(computerLabel);
        Style.setDefaultLabelFont(playerLabel);
        Style.setDefaultLabelFont(computerLabel);

        Style.setBoldFont(playerScoreLabel);
        Style.setBoldFont(computerScoreLabel);

        Style.setDefaultLabelFont(resultLabel);
        resultLabel.setVisible(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeWindow homeWindow = new HomeWindow();
                homeWindow.showHomeWindow();
                SwingUtilities.getWindowAncestor(gamePanel).dispose();
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
                wonSign = ' ';
                GameLogic.resetBoard(board);
            }
        });
        button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button00);
                board[0][0] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button01);
                board[0][1] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button02);
                board[0][2] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button10);
                board[1][0] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button11);
                board[1][1] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button12);
                board[1][2] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button20);
                board[2][0] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button21);
                board[2][1] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();
            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button22);
                board[2][2] = 1;
                if(GameLogic.checkMatrix(board, ComputerPlay.this)) {
                    setResult();
                    return;
                }

                computerMove();
                if(GameLogic.checkMatrix(board, ComputerPlay.this))
                    setResult();

                checkPossibleMoves();

            }
        });
    }

    public void showComputerWindow(){
        ComputerPlay computerPlay = new ComputerPlay();
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(computerPlay.gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        computerPlay.openInputDialog();
    }

    private void openInputDialog() {
        JTextField textField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(textField);

        int result = JOptionPane.showConfirmDialog(
                gamePanel,
                inputPanel,
                "Enter Name",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION)
            playerLabel.setText(textField.getText());
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

    private void setResult(){
        if(wonSign == 'X'){
            resultLabel.setText(playerLabel.getText()+" won!");
            playerScore++;
            playerScoreLabel.setText(String.valueOf(playerScore));
        }else if(wonSign == 'O'){
            resultLabel.setText("Computer won!");
            computerScore++;
            computerScoreLabel.setText(String.valueOf(computerScore));
        }
        Style.setTextColor(resultLabel, Color.decode("#5D8736"));
        Style.setBoldFont(resultLabel);
        resultLabel.setVisible(true);
        changeStateOfAllButtons(false);
    }

    private void checkPossibleMoves(){
        if(!GameLogic.isMovesLeft(board)){
            resultLabel.setText("TIE");
            Style.setTextColor(resultLabel, Color.red);
            Style.setDefaultLabelFont(resultLabel);
            resultLabel.setVisible(true);
        }
    }

    private void computerMove(){
        Move computer = findBestMove();
        int row = computer.row;
        int col = computer.col;

        JButton[] buttons = new JButton[9];
        buttons[0] = button00;
        buttons[1] = button01;
        buttons[2] = button02;
        buttons[3] = button10;
        buttons[4] = button11;
        buttons[5] = button12;
        buttons[6] = button20;
        buttons[7] = button21;
        buttons[8] = button22;

        buttons[0].setName("button00");
        buttons[1].setName("button01");
        buttons[2].setName("button02");
        buttons[3].setName("button10");
        buttons[4].setName("button11");
        buttons[5].setName("button12");
        buttons[6].setName("button20");
        buttons[7].setName("button21");
        buttons[8].setName("button22");

        String name =  "button" + String.valueOf(row) + String.valueOf(col);

        if(row != -1 && col != -1)
            board[row][col] = 0;
        for (JButton button : buttons) {
            if (button.getName().equals(name)) {
                button.setText("O");
                button.setEnabled(false);
                break;
            }
        }
    }
    /*********************************************************************************************************/
    private int evaluate() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != 2) {
                if (board[row][0] == 1)
                    return +10;
                else if (board[row][0] == 0)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != 2) {
                if (board[0][col] == 1)
                    return +10;
                else if (board[0][col] == 0)
                    return -10;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 2) {
            if (board[0][0] == 1)
                return +10;
            else if (board[0][0] == 0)
                return -10;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 2) {
            if (board[0][2] == 1)
                return +10;
            else if (board[0][2] == 0)
                return -10;
        }

        return 0;
    }

    private int minimax(int depth, Boolean isMax)
    {
        int score = evaluate();

        if (score == 10)
            return score - depth;

        if (score == -10)
            return score + depth;

        if (!GameLogic.isMovesLeft(board))
            return 0;

        if (isMax)
        {
            int best = -1000;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j]== 2)
                    {
                        board[i][j] = 1;
                        best = Math.max(best, minimax(depth + 1, !isMax));
                        board[i][j] = 2;
                    }
                }
            }
            return best;
        } else {
            int best = 1000;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j] == 2)
                    {
                        board[i][j] = 0;
                        best = Math.min(best, minimax(depth + 1, !isMax));
                        board[i][j] = 2;
                    }
                }
            }
            return best;
        }
    }

    class Move{
        int col;
        int row;
    }

    private Move findBestMove()
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == 2)
                {
                    board[i][j] = 1;

                    int moveVal = minimax(0, true);
                    board[i][j] = 2;
                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }
}
