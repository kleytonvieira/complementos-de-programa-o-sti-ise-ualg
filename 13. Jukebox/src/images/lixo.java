package images;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class lixo {

  private JFrame frame;
  private final ButtonGroup buttonGroup = new ButtonGroup();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          lixo window = new lixo();
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
  public lixo() {
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
    gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
    gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    frame.getContentPane().setLayout(gridBagLayout);
    
    JRadioButton rdbtnA = new JRadioButton("a");
    buttonGroup.add(rdbtnA);
    GridBagConstraints gbc_rdbtnA = new GridBagConstraints();
    gbc_rdbtnA.insets = new Insets(0, 0, 5, 5);
    gbc_rdbtnA.gridx = 1;
    gbc_rdbtnA.gridy = 1;
    frame.getContentPane().add(rdbtnA, gbc_rdbtnA);
    
    JComboBox comboBox = new JComboBox();
    GridBagConstraints gbc_comboBox = new GridBagConstraints();
    gbc_comboBox.insets = new Insets(0, 0, 5, 0);
    gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
    gbc_comboBox.gridx = 4;
    gbc_comboBox.gridy = 1;
    frame.getContentPane().add(comboBox, gbc_comboBox);
    
    JRadioButton rdbtnB = new JRadioButton("b");
    buttonGroup.add(rdbtnB);
    GridBagConstraints gbc_rdbtnB = new GridBagConstraints();
    gbc_rdbtnB.insets = new Insets(0, 0, 0, 5);
    gbc_rdbtnB.gridx = 1;
    gbc_rdbtnB.gridy = 2;
    frame.getContentPane().add(rdbtnB, gbc_rdbtnB);
  }

}
