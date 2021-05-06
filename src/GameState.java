public class GameState {
    private int[][] grid;

    public GameState() {
        grid = new int[3][3];
    }

    public void setOnPos(int x, int y, int value) {
        grid[x][y] = value;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getPos(int x, int y) {
        return grid[x][y];
    }

    private boolean isSameOnRow(int k) {
        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][k] != grid[i + 1][k] || grid[i][k] == 0) {
                return false;
            }

        }
        return true;
    }

    private boolean isSameOnColumn(int k) {
        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[k][i] != grid[k][i + 1] || grid[k][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameOnMainDiagonal() {
        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][i] != grid[i + 1][i + 1] || grid[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameOnSecondaryDiagonal() {
        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][grid.length - 1 - i] != grid[i + 1][grid.length - i - 2] || grid[i][grid.length - 1 - i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isFull() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDraw() {
        return isFull();
    }

    public boolean isWinner() {
        if (isSameOnMainDiagonal() || isSameOnSecondaryDiagonal()) {
            return true;
        }

        for (int i = 0; i < grid.length; i++) {
            if (isSameOnColumn(i) || isSameOnRow(i)) {
                return true;
            }
        }
        return false;

    }


}
