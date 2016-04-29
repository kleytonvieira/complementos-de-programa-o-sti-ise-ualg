

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class Jukebox {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Jukebox window = new Jukebox();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Jukebox() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{0, 0, 0};
    gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    frame.getContentPane().setLayout(gridBagLayout);
    try{
      ImageIcon icon = new ImageIcon("./src/images/facebook.png");
      JButton btnNewButton_1 = new JButton("New button");
      GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
      gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
      gbc_btnNewButton_1.gridx = 1;
      gbc_btnNewButton_1.gridy = 6;
      frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
      
      JButton btnNewButton = new JButton("New button", icon);
      GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
      gbc_btnNewButton.gridx = 1;
      gbc_btnNewButton.gridy = 7;
      frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

}
