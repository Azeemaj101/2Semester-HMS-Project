
import java.awt.BorderLayout;
import java.awt.EventQueue;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Login extends JFrame {
    /**
	 * 
	 */

    
	Image img_UserName =new ImageIcon(Login.class.getResource("UserName.JPG")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
	//Image image = ImageIO.read(getClass().getResourceAsStream("Key.png"));
	 private Image img_logo =new ImageIcon(Login.class.getResource("Logo.jpg")).getImage().getScaledInstance(220, 140, Image.SCALE_SMOOTH);
    private Image img_Password =new ImageIcon(Login.class.getResource("Lock.jpg")).getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH);
    private Image img_Login =new ImageIcon(Login.class.getResource("Key.png")).getImage().getScaledInstance(90, 80, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(163, 184, 250, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textUsername.getText().equals("UserName"))
				{
				   textUsername.setText("");	
				}
				else
				{
					textUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
			if(textUsername.getText().equals(""))
			{
				textUsername.setText("Usarname");
			}
			}
		});
		textUsername.setBorder(null);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textUsername.setText("UserName");
		textUsername.setBounds(10, 11, 198, 18);
		panel_1.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUserName = new JLabel("");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(209, 0, 41, 40);
		lblUserName.setIcon(new ImageIcon(img_UserName));
		panel_1.add(lblUserName);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(163, 235, 250, 40);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password"))
				{
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}
				else
				{
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals(""))
				{
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 200, 18);
		panel_1_1.add(txtPassword);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(209, 0, 41, 40);
		lblPassword.setIcon(new ImageIcon(img_Password));
		panel_1_1.add(lblPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			//LeftButton.setEnabled(false);
			}
		});
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textUsername.getText().equals("Admin") && txtPassword.getText().equals("Admin"))
				{
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successful");
					Login.this.dispose();
				}
				else if(textUsername.getText().equals("") || textUsername.getText().equals("Username")
						||txtPassword.getText().equals("")||txtPassword.getText().equals("Password"))
				{
					lblLoginMessage.setText("Please Input All Requirements!");
				}
				else
				{
					lblLoginMessage.setText("Username and Password didn't match");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(47, 79, 79));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				panel_2.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_2.setBackground(new Color(30, 60, 60));
			}
		});
		panel_2.addFocusListener(new FocusAdapter() {
		});
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(163, 303, 250, 63);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(99, 11, 104, 41);
		panel_2.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(55, 11, 41, 40);
		lblLogin.setIcon(new ImageIcon(img_Login));
		panel_2.add(lblLogin);
		
		JLabel lblx = new JLabel("x");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to close this Application", "Confirmation", JOptionPane.YES_NO_OPTION)==0)
			{
				Login.this.dispose();
			}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			   lblx.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				   lblx.setForeground(Color.GREEN);
				}
		});
		lblx.setVerticalAlignment(SwingConstants.BOTTOM);
		lblx.setForeground(new Color(192, 192, 192));
		lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setBounds(576, 0, 20, 20);
		panel.add(lblx);
		
		JLabel lbliconLogo = new JLabel("");
		lbliconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconLogo.setBounds(163, 28, 250, 126);
		panel.add(lbliconLogo);
		lbliconLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoginMessage.setForeground(new Color(178, 34, 34));
		lblLoginMessage.setBounds(163, 278, 250, 20);
		panel.add(lblLoginMessage);
		setLocationRelativeTo(null);
	}
}
