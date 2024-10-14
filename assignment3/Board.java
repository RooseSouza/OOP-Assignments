
public class Board {
    private Peg[][] pegs;

    public Board() {
        pegs = new Peg[7][7];
        initializeBoard();
    }

    // Copy constructor to clone the board for undo functionality
    public Board(Board otherBoard) {
        this.pegs = new Peg[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (otherBoard.pegs[i][j] != null) {
                    this.pegs[i][j] = new Peg(otherBoard.pegs[i][j].isFilled());
                }
            }
        }
    }

    private void initializeBoard() {
        // Initialize the board with the starting configuration
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i >= 2 && i <= 4) || (j >= 2 && j <= 4)) {
                    pegs[i][j] = new Peg(true); // Place pegs at valid positions
                } else {
                    pegs[i][j] = null; // Invalid positions
                }
            }
        }
        pegs[3][3].setFilled(false); // Starting empty position at the center
    }

    public Peg[][] getPegs() {
        return pegs;
    }

    public boolean isMoveValid(int startX, int startY, int endX, int endY) {
        // Check if move is within bounds and follows the game's rules
        if (startX < 0 || startX >= 7 || startY < 0 || startY >= 7 ||
            endX < 0 || endX >= 7 || endY < 0 || endY >= 7) {
            return false;
        }

        // Ensure the start peg is filled and the end peg is empty
        if (!pegs[startX][startY].isFilled() || pegs[endX][endY].isFilled()) {
            return false;
        }

        // Valid move: horizontally or vertically, jumping over a filled peg
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);

        if ((dx == 2 && dy == 0) || (dx == 0 && dy == 2)) {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;

            // Check that there's a filled peg in between
            return pegs[midX][midY].isFilled();
        }

        return false;
    }

    public void makeMove(int startX, int startY, int endX, int endY) {
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;

        // Make the move: remove the middle peg, move the start peg to the end position
        pegs[startX][startY].setFilled(false);
        pegs[midX][midY].setFilled(false);
        pegs[endX][endY].setFilled(true);
    }
}
