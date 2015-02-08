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

public class EShop_gui {

	private JFrame frame;
	private JButton btnCalculate;

	private static Integer i = 0;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EShop_gui window = new EShop_gui();
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
	public EShop_gui() {
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

		btnCalculate = new JButton("init cart");

		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("siham");
				// i++;

				// Cart myCart = new Cart();
				String name = txtName.getText();
				try {
					Cart newCart = Cart.init(name);
					if (newCart == null) {
						// TODO - write a message on window
						System.out.println("choose another name please");
					} else {
						Cart_gui myGUI = new Cart_gui(newCart);
						Cart_gui.main2(null);
						frame.setVisible(false);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnCalculate.setBounds(156, 118, 89, 23);
		frame.getContentPane().add(btnCalculate);

		txtName = new JTextField();
		txtName.setBounds(156, 74, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblInsertYourName = new JLabel("insert your name:");
		lblInsertYourName.setBounds(20, 77, 129, 14);
		frame.getContentPane().add(lblInsertYourName);

		JLabel lblWelcomeToEshop = new JLabel("Welcome to EShop");
		lblWelcomeToEshop.setBounds(162, 11, 135, 14);
		frame.getContentPane().add(lblWelcomeToEshop);
	}
}
