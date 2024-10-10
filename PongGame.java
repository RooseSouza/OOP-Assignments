import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements KeyListener, ActionListener {

    private int bottomPaddleX = 310; // Bottom paddle position (x)
    private int topPaddleX = 310;    // Top paddle position (x)
    private int ballPosX = 120;      // Ball position (x)
    private int ballPosY = 350;      // Ball position (y)
    private int ballXDir = -1;       // Ball movement direction (x)
    private int ballYDir = -2;       // Ball movement direction (y)
    private Timer timer;
    private int delay = 8;           // Ball movement speed
    private int bottomPlayerScore = 0;  // Score for the bottom player
    private int topPlayerScore = 0;     // Score for the top player

    public PongGame() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        // Borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);   // Left border
        g.fillRect(691, 0, 3, 592); // Right border

        // Bottom paddle
        g.setColor(Color.green);
        g.fillRect(bottomPaddleX, 550, 100, 8);

        // Top paddle
        g.setColor(Color.blue);
        g.fillRect(topPaddleX, 30, 100, 8); // Positioned at the top

        // The ball
        g.setColor(Color.red);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        // Scores display
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Bottom Player: " + bottomPlayerScore, 30, 20);
        g.drawString("Top Player: " + topPlayerScore, 500, 20);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        // Ball movement
        ballPosX += ballXDir;
        ballPosY += ballYDir;

        // Ball bouncing off left, right walls
        if (ballPosX < 0) {
            ballXDir = -ballXDir;
        }
        if (ballPosX > 670) {
            ballXDir = -ballXDir;
        }

        // Ball hitting the bottom paddle
        if (new Rectangle(ballPosX, ballPosY, 20, 20)
                .intersects(new Rectangle(bottomPaddleX, 550, 100, 8))) {
            ballYDir = -ballYDir;
        }

        // Ball hitting the top paddle
        if (new Rectangle(ballPosX, ballPosY, 20, 20)
                .intersects(new Rectangle(topPaddleX, 30, 100, 8))) {
            ballYDir = -ballYDir;
        }

        // If the ball crosses the bottom edge (Top player scores)
        if (ballPosY > 570) {
            topPlayerScore++;
            resetBall(); // Reset the ball after 1 second
        }

        // If the ball crosses the top edge (Bottom player scores)
        if (ballPosY < 0) {
            bottomPlayerScore++;
            resetBall(); // Reset the ball after 1 second
        }

        // Repaint the game after every movement
        repaint();
    }

    // Reset the ball position and continue after a brief pause
    private void resetBall() {
        ballPosX = 350;
        ballPosY = 250;
        ballXDir = -1;
        ballYDir = -2;
        try {
            Thread.sleep(1000);  // Pause the game for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Move both paddles left
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (bottomPaddleX <= 10) {
                bottomPaddleX = 10;
                topPaddleX = 10;
            } else {
                moveLeft();
            }
        }

        // Move both paddles right
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (bottomPaddleX >= 590) {
                bottomPaddleX = 590;
                topPaddleX = 590;
            } else {
                moveRight();
            }
        }
    }

    public void moveLeft() {
        bottomPaddleX -= 20;
        topPaddleX -= 20;
    }

    public void moveRight() {
        bottomPaddleX += 20;
        topPaddleX += 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PongGame pongGame = new PongGame();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Ping Pong Game with Scoring");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pongGame);
        frame.setVisible(true);
    }
}
