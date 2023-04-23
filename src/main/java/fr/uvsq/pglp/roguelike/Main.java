package fr.uvsq.pglp.roguelike;



import fr.uvsq.pglp.roguelike.elements.Donjon;
import fr.uvsq.pglp.roguelike.elements.Strategy;
import fr.uvsq.pglp.roguelike.elements.commande.Backward;
import fr.uvsq.pglp.roguelike.elements.commande.Forward;
import fr.uvsq.pglp.roguelike.elements.commande.Jbackward;
import fr.uvsq.pglp.roguelike.elements.commande.Jforward;
import fr.uvsq.pglp.roguelike.elements.commande.Jleft;
import fr.uvsq.pglp.roguelike.elements.commande.Jright;
import fr.uvsq.pglp.roguelike.elements.commande.Left;
import fr.uvsq.pglp.roguelike.elements.commande.No;
import fr.uvsq.pglp.roguelike.elements.commande.Right;
import fr.uvsq.pglp.roguelike.elements.commande.Yes;
import fr.uvsq.pglp.roguelike.elements.personnage.Builder;
import fr.uvsq.pglp.roguelike.elements.personnage.Pj;
import fr.uvsq.pglp.roguelike.elements.personnage.Pnj;
import fr.uvsq.pglp.roguelike.gui.GameBoard;
import fr.uvsq.pglp.roguelike.utils.Functions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;


/**
 * Main .
 */
public class Main {

  private static JFrame window;
  private static JFrame window2;
  private static GameBoard gameBoard;
  private static JTextField jt;
  private static JLabel jl;

  /**
   * Main methode .
   */
  public static void main(String[] args) {

    System.out.println("[Main]: Starting...");
    createWindow();

    createGameBoard();
    initGame();
    createCommandewindow();
  }


  /**
   * create window methode .
   */
  private static void createWindow() {
    System.out.println("[Main]: Creating window");
    window = new JFrame("Roguelike");
    window.setLocation(350, 100);
    window.setVisible(true);
    window.setBounds(250, 100, Reference.windowWidth, Reference.windowHeight);
    window.setSize(Reference.windowWidth + 10, Reference.windowHeight);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  private static  void createCommandewindow() {
    window2 = new JFrame("Commande");
    jt = new JTextField();

    jt.setFont(new Font("arial", Font.PLAIN, 30));
    jt.setBackground(Color.BLACK);
    jt.setForeground(Color.WHITE);
    jl = new JLabel();
    jl.setBackground(Color.BLACK);

    jl.setFont(new Font("arial", Font.PLAIN, 30));
    jl.setText("CMD >");
    jt.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
          String strCmd = jt.getText();
          switch (strCmd) {
            case "up":
              new Forward().execute();
              jt.setText("");
              break;
            case "down":
              new Backward().execute();
              jt.setText("");
              break;

            case "left":
              new Left().execute();
              jt.setText("");
              break;

            case "right":
              new Right().execute();
              jt.setText("");
              break;

            case "yes":
              new Yes().execute();
              jt.setText("");
              break;
            case "no":
              new No().execute();
              jt.setText("");
              break;
            case "jf":
              new Jforward().execute();
              jt.setText("");
              break;
            case "jb":
              new Jbackward().execute();
              jt.setText("");
              break;
            case "jr":
              new Jright().execute();
              jt.setText("");
              break;
            case "jl":
              new Jleft().execute();
              jt.setText("");
              break;
            default:
              break;

          }
        }

      }

      @Override
      public void keyReleased(KeyEvent e) {

      }
    });

    window2.add(jl, BorderLayout.NORTH);
    window2.add(jt, BorderLayout.CENTER);
    window2.setSize(250, 150);
    window2.setVisible(true);
    window2.setResizable(false);
    window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  private static void createGameBoard() {
    System.out.println("");
    gameBoard = new GameBoard();
    window.add(gameBoard);
    gameBoard.requestFocusInWindow();

  }

  /**Starts a new game .*/
  public static void initGame() {
    //initialization
    Reference.currentDonjon = new Donjon(1, Strategy.PREDEFF);
    Builder playerbuilder = new Builder("Player", 0, 3, 2, 20, 5, 1);
    Reference.pj = new Pj(playerbuilder);
    Reference.pnjs = new ArrayList<Pnj>();
    Reference.friendlies = new ArrayList<Pnj>();
    Reference.vendeurs = new ArrayList<Pnj>();
    Functions.initMovingTiles();

  }

}
