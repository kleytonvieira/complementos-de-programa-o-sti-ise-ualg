import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreDB.
 */
public class StoreDB {

  /** The frame. */
  private JFrame frame;

  /** The txt client adress. */
  private JTextField txtClientAdress;

  /** The txt client name. */
  private JTextField txtClientName;

  /** The txt client id. */
  private JTextField txtClientId;

  /** The table buy. */
  private JTable tableBuy;

  /** The Constant JDBC_DRIVER. */
  static final String JDBC_DRIVER = "org.sqlite.JDBC";

  /** The Constant DB_URL. */
  static final String DB_URL = "jdbc:sqlite:store.sqlite";

  /** The conn. */
  private Connection conn = null;

  /** The txt filter. */
  private JTextField txtFilter;

  /** The list clients. */
  private JList listClients;

  /** The Main panel. */
  private JPanel MainPanel;

  /** The Client panel. */
  private JPanel ClientPanel;

  /** The btn new client. */
  private JButton btnNewClient;

  /** The btn delete client. */
  private JButton btnDeleteClient;
  private JScrollPane scrollPane_1;

  /**
   * Launch the application.
   *
   * @param args
   *          the arguments
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          StoreDB window = new StoreDB();
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
  public StoreDB() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 496, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new CardLayout(0, 0));

    MainPanel = new JPanel();
    frame.getContentPane().add(MainPanel, "name_12995790341051");
    MainPanel.setLayout(null);

    JLabel lblFilter = new JLabel("Filter");
    lblFilter.setBounds(45, 35, 70, 15);
    MainPanel.add(lblFilter);

    txtFilter = new JTextField();
    txtFilter.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        String sql = "SELECT * FROM Client";
        sql += " WHERE ClientName LIKE '%" + txtFilter.getText() + "%'";
        sql += " OR clientAdress LIKE '%" + txtFilter.getText() + "%'";
        System.out.println(sql);
        loadClientTable(sql);
      }
    });
    txtFilter.setBounds(92, 33, 114, 19);
    MainPanel.add(txtFilter);
    txtFilter.setColumns(10);

    DefaultListModel<String> clientsListModel = new DefaultListModel<String>();

    scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(45, 64, 406, 243);
    MainPanel.add(scrollPane_1);
    listClients = new JList(clientsListModel);
    scrollPane_1.setViewportView(listClients);
    listClients.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          loadSelectedClient();
        }
      }
    });

    btnNewClient = new JButton("New");
    btnNewClient.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        insertNewClient();
      }
    });
    btnNewClient.setBounds(45, 334, 117, 25);
    MainPanel.add(btnNewClient);

    btnDeleteClient = new JButton("Delete");
    btnDeleteClient.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int selectedIdx = listClients.getSelectedIndex();
        if (selectedIdx == -1)
          return;
        DefaultListModel<Client> clm = (DefaultListModel<Client>) listClients.getModel();
        try {
          Statement stmt = conn.createStatement();
          stmt.executeUpdate("DELETE FROM Client WHERE ClientID = " + clm.getElementAt(selectedIdx).getClientId());
          String sql = "SELECT * FROM Client";
          sql += " WHERE ClientName LIKE '%" + txtFilter.getText() + "%'";
          sql += " OR clientAdress LIKE '%" + txtFilter.getText() + "%'";
          System.out.println(sql);
          loadClientTable(sql);
        } catch (Exception ee) {
          System.out.println(ee.getMessage());
        }
      }
    });
    btnDeleteClient.setBounds(174, 334, 117, 25);
    MainPanel.add(btnDeleteClient);

    ClientPanel = new JPanel();
    frame.getContentPane().add(ClientPanel, "name_12982376766486");
    ClientPanel.setLayout(null);

    JLabel lblAdress = new JLabel("Adress");
    lblAdress.setBounds(46, 140, 49, 15);
    ClientPanel.add(lblAdress);

    JLabel lblId = new JLabel("Id");
    lblId.setBounds(46, 83, 13, 15);
    ClientPanel.add(lblId);

    txtClientAdress = new JTextField();
    txtClientAdress.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        updateClient();
      }
    });
    txtClientAdress.setBounds(113, 138, 320, 19);
    ClientPanel.add(txtClientAdress);
    txtClientAdress.setColumns(10);

    txtClientName = new JTextField();
    txtClientName.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        updateClient();
      }
    });

    txtClientName.setBounds(113, 107, 320, 19);
    ClientPanel.add(txtClientName);
    txtClientName.setColumns(10);

    txtClientId = new JTextField();
    txtClientId.setEnabled(false);
    txtClientId.setBounds(113, 81, 114, 19);
    ClientPanel.add(txtClientId);
    txtClientId.setColumns(10);

    JLabel lblClients = new JLabel("-- Clients-- ");
    lblClients.setBounds(11, 34, 77, 15);
    ClientPanel.add(lblClients);

    JLabel lblName = new JLabel("Name");
    lblName.setBounds(46, 110, 40, 15);
    ClientPanel.add(lblName);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(46, 182, 397, 190);
    ClientPanel.add(scrollPane);

    DefaultTableColumnModel tcm = new DefaultTableColumnModel();

    tableBuy = new JTable();
    scrollPane.setViewportView(tableBuy);

    JButton btnBack = new JButton("Back");
    btnBack.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        MainPanel.setVisible(true);
        ClientPanel.setVisible(false);

      }
    });
    btnBack.setBounds(337, 34, 117, 25);
    ClientPanel.add(btnBack);

    openConnection();
    loadClientTable("SELECT * FROM Client");

  }

  /**
   * Open connection.
   */
  private void openConnection() {
    try {
      Class.forName(JDBC_DRIVER);
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  /**
   * Update client.
   */
  protected void updateClient() {
    String sql = "UPDATE Client SET ClientName = '" + txtClientName.getText() + "', ClientAdress = '"
        + txtClientAdress.getText() + "' WHERE ClientId = " + txtClientId.getText();
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
      stmt.close();
    } catch (SQLException e) {
      System.out.println(sql + e.getMessage());
    }

    DefaultListModel<Client> lm = (DefaultListModel<Client>) listClients.getModel();
    Client c = (Client) lm.getElementAt(listClients.getSelectedIndex());
    //  c.setClientId(Integer.parseInt(txtClientId.getText()));
    c.setClientName(txtClientName.getText());
    c.setClientAdress(txtClientAdress.getText());
    
    lm.setElementAt(c, listClients.getSelectedIndex());

    System.out.println("updated" + c.getClientName());

  }

  /**
   * Load client table.
   *
   * @param sql
   *          the sql
   */
  protected void loadClientTable(String sql) {
    Statement stmt = null;
    try {
      System.out.println("loadClientTable: Quering database...");
      stmt = conn.createStatement();
      ResultSet rsClient = stmt.executeQuery(sql);

      DefaultListModel<Client> vc = new DefaultListModel<Client>();
      while (rsClient.next()) {
        vc.addElement(new Client(rsClient.getInt("ClientId"), rsClient.getString("ClientName"),
            rsClient.getString("Clientadress")));
      }
      listClients.setModel(vc);
      stmt.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Insert new client.
   */
  private void insertNewClient() {
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate("INSERT INTO Client (ClientName, ClientAdress) VALUES ('-', '-')");
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        DefaultListModel lm = (DefaultListModel) listClients.getModel();
        lm.addElement(new Client(rs.getInt(1), "", ""));
        listClients.setSelectedIndex(listClients.getLastVisibleIndex());
        listClients.setSelectedIndex(lm.getSize());
        loadSelectedClient();
      }
      stmt.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  /**
   * Load selected client.
   */
  private void loadSelectedClient() {
    MainPanel.setVisible(false);
    ClientPanel.setVisible(true);
    Client c = (Client) listClients.getSelectedValue();
    txtClientId.setText("" + c.getClientId());
    txtClientName.setText(c.getClientName());
    txtClientAdress.setText(c.getClientAdress());
  }

  /**
   * Gets the list clients.
   *
   * @return the list clients
   */
  protected JList getListClients() {
    return listClients;
  }

  /**
   * Gets the main panel.
   *
   * @return the main panel
   */
  protected JPanel getMainPanel() {
    return MainPanel;
  }

  /**
   * Gets the client panel.
   *
   * @return the client panel
   */
  protected JPanel getClientPanel() {
    return ClientPanel;
  }
}
