import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainProgramAnimalFormAndList {

  private JFrame frame;
  private JTextField textField1stName;
  private JTextField textFieldSurname;
  private JButton btnOk;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainProgramAnimalFormAndList window = new MainProgramAnimalFormAndList();
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
  public MainProgramAnimalFormAndList() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
    
    JLabel lbl1stname = new JLabel("First name");
    frame.getContentPane().add(lbl1stname, "cell 0 1,alignx trailing");
    
    textField1stName = new JTextField();
    frame.getContentPane().add(textField1stName, "cell 1 1,growx");
    textField1stName.setColumns(10);
    
    JLabel lblSurname = new JLabel("Surname");
    frame.getContentPane().add(lblSurname, "cell 0 2,alignx trailing");
    
    textFieldSurname = new JTextField();
    frame.getContentPane().add(textFieldSurname, "cell 1 2,growx");
    textFieldSurname.setColumns(10);
    
    btnOk = new JButton("ok");
    btnOk.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("---"+ frame.getTitle().toString());
        frame.setTitle(getTextField1stName().getText() + " " + getTextFieldSurname().getText());
      }
    });
    frame.getContentPane().add(btnOk, "cell 1 3");
  }

  public JTextField getTextField1stName() {
    return textField1stName;
  }
  public JTextField getTextFieldSurname() {
    return textFieldSurname;
  }
}
