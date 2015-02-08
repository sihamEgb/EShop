package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import technion.eshop.entities.Cart;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;

public class Cart_gui {

	private JFrame frame;
	private  static String customerName;
	private static JLabel label_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart_gui window = new Cart_gui(customerName);
					window.frame.setVisible(true);
					label_1.setText(customerName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cart_gui(String name) {
		customerName = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(10, 11, 87, 14);
		frame.getContentPane().add(lblWelcome);
		
		label_1 = new JLabel("");
		label_1.setBounds(85, 11, 46, 14);
		frame.getContentPane().add(label_1);
		
		}
}
