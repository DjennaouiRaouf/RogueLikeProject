package fr.uvsq.pglp.roguelike.gui;

import fr.uvsq.pglp.roguelike.Main;
import fr.uvsq.pglp.roguelike.Reference;
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
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Game .
 */
public class GameBoard extends JPanel implements KeyListener {
  private JTextField textField;

  /**
   * GameBoard.
   */
  public GameBoard() {

    addKeyListener(this);
    this.setFocusable(true);

  }

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    repaint();
    revalidate();

    //Background
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
    g.setColor(Color.WHITE);
    g.drawRoundRect(5, 5, Reference.windowWidth - 220,
        Reference.windowHeight - 150, 5, 5);
    g.drawRoundRect(790, 5, Reference.windowWidth - 800,
        Reference.windowHeight - 150, 5, 5);
    g.drawRoundRect(5, Reference.windowHeight - 140,
        Reference.windowWidth - 15, Reference.windowHeight - 500, 5, 5);

    //Floor
    g.setColor(Color.WHITE);

    int x;
    int y;
    if (Reference.currentDonjon.isFirstFloor()) {
      x = 90;
      y = 50;
    } else {
      x = 15;
      y = 20;
    }

    for (int i = 0; i < Reference.currentDonjon.getHeight(); i++) {
      for (int j = 0; j < Reference.currentDonjon.getWidth(); j++) {
        g.drawString("" + Reference.currentDonjon.getTileChar(j, i), x, y);
        x += 10;
      }
      //y+=15; x=15;
      if (Reference.currentDonjon.isFirstFloor()) {
        x = 90;
        y += 15;
      } else {
        x = 15;
        y += 15;
      }
    }

    //Player stats
    g.setFont(new Font("arial", Font.PLAIN, 30));
    g.drawString("PJ", 800, 50);
    g.setFont(new Font("arial", Font.PLAIN, 15));
    g.drawString("PV: " + Reference.pj.getHp() + "/" + Reference.pj.getMaxhp(), 800, 75);
    g.drawString("ATT: " + Reference.pj.getStr(), 800, 95);
    g.drawString("DEF: " + Reference.pj.getDef(), 800, 115);
    g.drawString("ARGENT: " + Reference.pj.getGold(), 800, 140);
    g.drawString("CLEFS: " + Reference.pj.getKeys(), 800, 160);
    g.drawString("Arme:", 800, 185);
    g.drawString(Reference.pj.getWeapon().getName(), 810, 205);
    g.drawString("Armure:", 800, 230);
    g.drawString(Reference.pj.getArmor().getName(), 810, 250);

    //Message
    g.drawString(Functions.getMessage(), 15, 480);
    g.drawString(Functions.getMessage2(), 15, 500);
    g.drawString(Functions.getMessage3(), 15, 520);

    //Title
    if (Reference.currentDonjon.isFirstFloor()) {
      g.setFont(new Font("arial", Font.PLAIN, 15));
      g.drawString(Functions.getMessage(), 300, 190);

    }
  }

  @Override
  public void keyPressed(KeyEvent arg0) {
    if (Reference.pj.isAlive()) {
      switch (arg0.getKeyCode()) {
        //Move player foward

        case KeyEvent.VK_UP:
          new Forward().execute();
          break;
        //Move player left
        case KeyEvent.VK_LEFT:
          new Left().execute();
          break;
        //Move player Backwards
        case KeyEvent.VK_DOWN:
          new Backward().execute();
          break;
        //Move player right
        case KeyEvent.VK_RIGHT:
          new Right().execute();
          break;
        //Make decision Yes
        case KeyEvent.VK_O:
          new Yes().execute();
          break;
        //Make decision No
        case KeyEvent.VK_N:
          new No().execute();
          break;

        case KeyEvent.VK_Z:
          new Jforward().execute();
          break;
        case KeyEvent.VK_S:
          new Jbackward().execute();
          break;
        case KeyEvent.VK_D:
          new Jright().execute();
          break;

        case KeyEvent.VK_Q:
          new Jleft().execute();
          break;

        default:
          break;
      }
      Functions.checkPlayerDeath();
    } else {
      Main.initGame();
    }
  }

  @Override
  public void keyReleased(KeyEvent arg0) {}

  @Override
  public void keyTyped(KeyEvent arg0) {}

}
