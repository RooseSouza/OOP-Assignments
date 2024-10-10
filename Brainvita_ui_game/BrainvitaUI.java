
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BrainvitaUI extends JFrame {
    private Board board;
    private Board previousBoard;
    private JButton[][] buttons;
    private int startX, startY;
    private boolean isFirstClick;
    private ImageIcon filledMarbleIcon;
    private ImageIcon emptySpotIcon;
    private JButton restartButton, undoButton;
    private JLabel scoreLabel, highScoreLabel;
    private int moveCount, tempScore;
    private int highScore;

    public BrainvitaUI() {
        board = new Board();
        buttons = new JButton[7][7];
        isFirstClick = true;
        moveCount = 0;
        highScore = Integer.MAX_VALUE; // High score starts as a large number (fewer moves is better)

        // Load and resize the marble images
        filledMarbleIcon = new ImageIcon(new ImageIcon(getClass().getResource("marble.jpeg")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
        emptySpotIcon = new ImageIcon(new ImageIcon(getClass().getResource("white.png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));

        setTitle("Brainvita");
        setSize(500, 600); // Adjusted size to accommodate the buttons and score
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize the board with buttons
        JPanel boardPanel = new JPanel(new GridLayout(7, 7));
        initializeButtons(boardPanel);

        // Initialize the restart, undo buttons, and score labels
        restartButton = new JButton("Restart Game");
        undoButton = new JButton("Undo");
        scoreLabel = new JLabel("Moves: 0");
        highScoreLabel = new JLabel("High Score: -");

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoMove();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(undoButton);
        buttonPanel.add(restartButton);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2, 1));
        scorePanel.add(scoreLabel);
        scorePanel.add(highScoreLabel);

        add(boardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scorePanel, BorderLayout.NORTH);

        updateBoard();
        setVisible(true);
    }

    private void initializeButtons(JPanel boardPanel) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new JButton();
                if (board.getPegs()[i][j] != null) {
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].addActionListener(new PegActionListener(i, j));
                } else {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setBackground(Color.GRAY);
                }
                boardPanel.add(buttons[i][j]);
            }
        }
    }

    private void updateBoard() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getPegs()[i][j] != null) {
                    if (board.getPegs()[i][j].isFilled()) {
                        buttons[i][j].setIcon(filledMarbleIcon);
                    } else {
                        buttons[i][j].setIcon(emptySpotIcon);
                    }
                }
            }
        }

        // Check if the player has won the game
        checkWinCondition();
    }

    private void updateScorePlaying() {
        scoreLabel.setText("Moves: " + moveCount);
        tempScore = moveCount;
    }

    private void resetScore() {
        if (tempScore < highScore) {
            highScore = tempScore;
            highScoreLabel.setText("High Score: " + highScore);
        }
    }

    private void restartGame() {
        board = new Board();
        isFirstClick = true;
        moveCount = 0;
        updateBoard();
        updateScorePlaying();
    }

    private void undoMove() {
        if (previousBoard != null) {
            board = previousBoard;
            previousBoard = null; // Reset previousBoard after undo
            updateBoard();
            moveCount--; // Decrease move count when undoing
            updateScorePlaying();
        }
    }

    private void checkWinCondition() {
        int filledCount = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getPegs()[i][j] != null && board.getPegs()[i][j].isFilled()) {
                    filledCount++;
                }
            }
        }
        if (filledCount == 1) { // Winning condition: Only one marble left
            JOptionPane.showMessageDialog(this, "Congratulations! You've won the game in " + moveCount + " moves.");
            resetScore();
        }
    }

    private class PegActionListener implements ActionListener {
        private int x, y;

        public PegActionListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFirstClick) {
                startX = x;
                startY = y;
                if (board.getPegs()[startX][startY].isFilled()) {
                    isFirstClick = false;
                }
            } else {
                int endX = x;
                int endY = y;
                if (board.isMoveValid(startX, startY, endX, endY)) {
                    previousBoard = new Board(board); // Assuming a copy constructor in Board
                    board.makeMove(startX, startY, endX, endY);
                    moveCount++; // Increment move count
                    updateBoard();
                    updateScorePlaying();
                }
                isFirstClick = true;
            }
        }
    }

    public static void main(String[] args) {
        new BrainvitaUI();
    }
}
