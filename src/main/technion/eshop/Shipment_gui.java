package technion.eshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import technion.eshop.entities.Cart;
import technion.eshop.entities.Product;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Shipment_gui {

	private JFrame frame;
	private JTextField textField;
	private JComboBox<Product> comboBox;

	/**
	 * Launch the application.
	 */
	public void main3(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shipment_gui window = new Shipment_gui();
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
	public Shipment_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				System.out.println("thank you for using ESHop");
			}
		});
		btnSend.setBounds(335, 228, 89, 23);
		// TODO disable button !!!
		btnSend.enableInputMethods(false);
		frame.getContentPane().add(btnSend);

		JLabel label = new JLabel("insert your name:");
		label.setBounds(31, 34, 129, 14);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 31, 86, 20);
		frame.getContentPane().add(textField);

		JLabel lblAddProductsTo = new JLabel("add products to boxes");
		lblAddProductsTo.setBounds(31, 88, 108, 14);
		frame.getContentPane().add(lblAddProductsTo);

		comboBox = new JComboBox<Product>();
		comboBox.setBounds(172, 85, 89, 20);
		frame.getContentPane().add(comboBox);

	}
}
