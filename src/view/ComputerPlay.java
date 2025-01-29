package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerPlay {
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

    public static void setWonSign(char wonSign) {
        ComputerPlay.wonSign = wonSign;
    }

    public static char getWonSign() {
        return wonSign;
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

                //stateOfSign = false;
                wonSign = ' ';
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        board[i][j] = 2;
                    }
                }
            }
        });
        button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button00);
                //int num = stateOfSign ? 1 : 0;
                board[0][0] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button01);
                //int num = stateOfSign ? 1 : 0;
                board[0][1] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button02);
                //int num = stateOfSign ? 1 : 0;
                board[0][2] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button10);
                //int num = stateOfSign ? 1 : 0;
                board[1][0] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button11);
                //int num = stateOfSign ? 1 : 0;
                board[1][1] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button12);
                //int num = stateOfSign ? 1 : 0;
                board[1][2] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button20);
                //int num = stateOfSign ? 1 : 0;
                board[2][0] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button21);
                //int num = stateOfSign ? 1 : 0;
                board[2][1] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();
            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLogic.buttonSet(button22);
                //int num = stateOfSign ? 1 : 0;
                board[2][2] = 1;
                computerMove();
                if(GameLogic.checkMatrix(board))
                    setResult();

                checkPossibleMoves();

            }
        });
    }

    public void showComputerWindow(){
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(new ComputerPlay().gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //openInputDialog();
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
            resultLabel.setText("Player won!");
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
    int evaluate() {
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


    // This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
    int minimax(int depth, Boolean isMax)
    {
        int score = evaluate();
        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score - depth;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score + depth;

        // If there are no more moves and
        // no winner then it is a tie
        if (!GameLogic.isMovesLeft(board))
            return 0;

        // If this maximizer's move
        if (isMax)
        {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]== 2)
                    {
                        // Make the move
                        board[i][j] = 1;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(depth + 1, !isMax));
                        System.out.println(i + " "+ j + "  " + best);
                        // Undo the move
                        board[i][j] = 2;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j] == 2)
                    {
                        // Make the move
                        board[i][j] = 0;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(depth + 1, !isMax));
                        // Undo the move
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
    // This will return the best possible
// move for the player
    Move findBestMove()
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // Check if cell is empty
                if (board[i][j] == 2)
                {
                    // Make the move
                    board[i][j] = 1;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(0, true);

                    // Undo the move
                    board[i][j] = 2;

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        System.out.println("The value of the best Move " + bestMove.row + " " + bestMove.col);

        return bestMove;
    }
}
