import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardWindow extends Canvas {

  private JFrame frame;
  private Board board;

  private String title;

  private int cellSize = 30;

  public BoardWindow(Board board, String title) {
    this.board = board;
    this.title = title;
    initBoardWindow();
  }

  public BoardWindow(Board board, String title, int cellSize) {
    this.board = board;
    this.title = title;
    this.cellSize = cellSize;
    initBoardWindow();
  }

  private void initBoardWindow() {
    this.frame = new JFrame(this.title);
    this.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    this.setSize(board.getColumnCount() * cellSize, board.getRowCount() * cellSize);
    this.frame.add(this);
    this.frame.pack();
    this.frame.setVisible(true);
  }

  public void showBoard() {
    this.frame.setVisible(true);
  }

  public void hideBoard() {
    this.frame.setVisible(false);
  }

  private void drawCell(int row, int column, Color color, Graphics g) {
    g.setColor(color);
    g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
  }

  private void drawImage(int row, int column, Graphics g, String imagePath) {
    File file = new File("resources/" + imagePath);
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File(file.getAbsolutePath()));
      g.drawImage(image, column*cellSize, row*cellSize, cellSize, cellSize, this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    for (int i = 0; i < board.getRowCount(); i++) {
      for (int j = 0; j < board.getColumnCount(); j++) {
        Cell cell = board.getCells()[i][j];
        String imagePath = cell.getImagePath();
        switch (cell.getCellType()) {
          case VISITED:
            if (imagePath == null) {
              drawCell(i, j, new Color(0x413F42), g);
            } else {
              drawImage(i, j, g, imagePath);
            }
            break;
          case CURRENT_ROOM:
            if (imagePath == null) {
              drawCell(i, j, new Color(0x7F8487), g);
            } else {
              drawImage(i, j, g, imagePath);
            }
            break;
          case START:
            drawCell(i, j, new Color(0xCAF0F8), g);
            break;
          case EMPTY:
            drawCell(i, j, new Color(0x181818), g);
            break;
          default:
            break;
        }
      }
    }
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public int getCellSize() {
    return cellSize;
  }

  public void setCellSize(int cellSize) {
    this.cellSize = cellSize;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
//  public static void main(String[] args) {
//    Board board1 = new Board(2,2);
//    BoardWindow boardWindow = new BoardWindow(board1, "My Example Board", 100);
//    boardWindow.getBoard().setCell(0, 0, CellType.START);
//    boardWindow.getBoard().setCell(0, 0, CellType.CURRENT_ROOM);
//    boardWindow.getBoard().setCell(0, 1, CellType.VISITED);
//  }
//}
