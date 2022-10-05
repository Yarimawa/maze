// 18.20: Maze.java

public class Maze {
  // 0s represent walls, 1s represent path ways
  private static char[][] route = {
    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
    {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
    {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
    {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
    {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
    {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
    {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
    {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
    {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
    {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
  };

  private static int exitRow = 4;
  private static int exitColumn = 11;

  private static int[][] spots_with_multiple_paths;

  private static boolean run(int currentRow, int currentColumn) {
    route[currentRow][currentColumn] = 'x';
    if (currentColumn == 11) {
      displayMaze();
      System.out.printf("Exit location: row %d, column %d\n", currentRow, currentColumn);
      System.exit(0);
    } else {
      // getAllPossibleMoves(currentRow, currentColumn);
      if (route[currentRow - 1][currentColumn] == '.') { // possible upward path
        // System.out.printf("Now Following: row %d, column %d\n", currentRow, currentColumn);
        run(currentRow - 1, currentColumn);
      }
      if (currentColumn < 11)
        if (route[currentRow][currentColumn + 1] == '.') { // possible rightward path
          // System.out.printf("Now Following: row %d, column %d\n", currentRow, currentColumn);
          run(currentRow, currentColumn + 1);
        }
      if (route[currentRow + 1][currentColumn] == '.') { // possible downward path
        // System.out.printf("Now Following: row %d, column %d\n", currentRow, currentColumn);
        run(currentRow + 1, currentColumn);
      }
      if (route[currentRow][currentColumn - 1] == '.') { // possible leftward path
        // System.out.printf("Now Following: row %d, column %d\n", currentRow, currentColumn);
        run(currentRow, currentColumn - 1);
      }
      // run(currentRow, currentColumn, getNextPossibleMoves(currentRow, currentColumn));
    }
    return false;
  } // end method run

  private static void getAllPossibleMoves(int currentRow, int currentColumn) {
    int count = 0;  // holds number of paths accessible from current position

    if (route[currentRow][currentColumn + 1] == '.')  // possible rightward shift
    count++;
    if (route[currentRow][currentColumn - 1] == '.')  // possible leftward shift
    count++;
    if (route[currentRow - 1][currentColumn] == '.')  // possible upward shift
    count++;
    if (route[currentRow + 1][currentColumn] == '.')  // possible downward shift
    count++;

    // if (count > 1)
    //   spots_with_multiple_paths[spots_with_multiple_paths.length] = {currentRow, currentColumn};
    return;
  } // end method getAllPossibleMoves

  private static void displayMaze() {
    for (char[] row : route) {
      for (char item : row )
        System.out.printf("%c ", item);
      System.out.println();
    }
  } // end method displayMaze

  public static void main(String[] args) {
    Maze.run(2, 0);
    System.out.print("Exit not found. Maze unsolvable :(");
  }
} // end class Maze
