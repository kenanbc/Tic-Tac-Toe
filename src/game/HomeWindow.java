package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindow {
    private JPanel homePanel;
    private JButton twoPlayersButton;
    private JButton playVsComputerButton;
    private JLabel twoPlayerLabel;
    private JLabel computerLabel;
    private JLabel titleLabel;

    public HomeWindow() {
        twoPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWindow gameWindow = new GameWindow();
                gameWindow.showGameWindow();
                SwingUtilities.getWindowAncestor(homePanel).dispose();
            }
        });
        playVsComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputerPlay computerWindow = new ComputerPlay();
                computerWindow.showComputerWindow();
                SwingUtilities.getWindowAncestor(homePanel).dispose();
            }
        });
    }

    public void showHomeWindow(){
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(new HomeWindow().homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
